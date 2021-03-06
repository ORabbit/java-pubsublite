/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsublite.beam;

import static com.google.cloud.pubsublite.internal.ExtractStatus.toCanonical;
import static com.google.cloud.pubsublite.internal.UncheckedApiPreconditions.checkArgument;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.pubsublite.AdminClient;
import com.google.cloud.pubsublite.AdminClientSettings;
import com.google.cloud.pubsublite.Partition;
import com.google.cloud.pubsublite.TopicPath;
import com.google.cloud.pubsublite.internal.wire.Committer;
import com.google.cloud.pubsublite.internal.wire.Subscriber;
import com.google.cloud.pubsublite.proto.SequencedMessage;
import com.google.common.base.Stopwatch;
import com.google.common.math.LongMath;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.apache.beam.sdk.io.range.OffsetRange;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn.OutputReceiver;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.splittabledofn.RestrictionTracker;
import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.Duration;

class SubscribeTransform extends PTransform<PBegin, PCollection<SequencedMessage>> {
  private static final Duration MAX_SLEEP_TIME = Duration.standardMinutes(1);

  private final SubscriberOptions options;

  SubscribeTransform(SubscriberOptions options) {
    this.options = options;
  }

  private void checkSubscription(SubscriptionPartition subscriptionPartition) throws ApiException {
    checkArgument(subscriptionPartition.subscription().equals(options.subscriptionPath()));
  }

  private Subscriber newSubscriber(Partition partition, Consumer<List<SequencedMessage>> consumer) {
    try {
      return options
          .getSubscriberFactory(partition)
          .newSubscriber(
              messages ->
                  consumer.accept(
                      messages.stream()
                          .map(message -> message.toProto())
                          .collect(Collectors.toList())));
    } catch (Throwable t) {
      throw toCanonical(t).underlying;
    }
  }

  private SubscriptionPartitionProcessor newPartitionProcessor(
      SubscriptionPartition subscriptionPartition,
      RestrictionTracker<OffsetRange, OffsetByteProgress> tracker,
      OutputReceiver<SequencedMessage> receiver)
      throws ApiException {
    checkSubscription(subscriptionPartition);
    return new SubscriptionPartitionProcessorImpl(
        tracker,
        receiver,
        consumer -> newSubscriber(subscriptionPartition.partition(), consumer),
        options.flowControlSettings());
  }

  private RestrictionTracker<OffsetRange, OffsetByteProgress> newRestrictionTracker(
      SubscriptionPartition subscriptionPartition, OffsetRange initial) {
    checkSubscription(subscriptionPartition);
    return new OffsetByteRangeTracker(
        initial,
        options.getBacklogReader(subscriptionPartition.partition()),
        Stopwatch.createUnstarted(),
        MAX_SLEEP_TIME.multipliedBy(3).dividedBy(4),
        LongMath.saturatedMultiply(options.flowControlSettings().bytesOutstanding(), 10));
  }

  private InitialOffsetReader newInitialOffsetReader(SubscriptionPartition subscriptionPartition) {
    checkSubscription(subscriptionPartition);
    return options.getInitialOffsetReader(subscriptionPartition.partition());
  }

  private Committer newCommitter(SubscriptionPartition subscriptionPartition) {
    checkSubscription(subscriptionPartition);
    return options.getCommitter(subscriptionPartition.partition());
  }

  private TopicPath getTopicPath() {
    try (AdminClient admin =
        AdminClient.create(
            AdminClientSettings.newBuilder()
                .setRegion(options.subscriptionPath().location().region())
                .build())) {
      return TopicPath.parse(admin.getSubscription(options.subscriptionPath()).get().getTopic());
    } catch (Throwable t) {
      throw toCanonical(t).underlying;
    }
  }

  @Override
  public PCollection<SequencedMessage> expand(PBegin input) {
    PCollection<SubscriptionPartition> subscriptionPartitions;
    if (options.partitions().isEmpty()) {
      subscriptionPartitions =
          input.apply(new SubscriptionPartitionLoader(getTopicPath(), options.subscriptionPath()));
    } else {
      subscriptionPartitions =
          input.apply(
              Create.of(
                  options.partitions().stream()
                      .map(
                          partition ->
                              SubscriptionPartition.of(options.subscriptionPath(), partition))
                      .collect(Collectors.toList())));
    }

    return subscriptionPartitions.apply(
        ParDo.of(
            new PerSubscriptionPartitionSdf(
                MAX_SLEEP_TIME,
                this::newInitialOffsetReader,
                this::newRestrictionTracker,
                this::newPartitionProcessor,
                this::newCommitter)));
  }
}
