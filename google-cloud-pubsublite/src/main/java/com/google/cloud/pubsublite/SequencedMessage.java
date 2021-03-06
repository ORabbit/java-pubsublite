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

package com.google.cloud.pubsublite;

import com.google.auto.value.AutoValue;
import com.google.cloud.pubsublite.proto.Cursor;
import com.google.common.base.Preconditions;
import com.google.protobuf.Timestamp;

/** A message with its sequencing information in the partition. */
@AutoValue
public abstract class SequencedMessage {
  /** Construct a SequencedMessage from its components. */
  public static SequencedMessage of(
      Message message, Timestamp publishTime, Offset offset, long byteSize) {
    return new AutoValue_SequencedMessage(message, publishTime, offset, byteSize);
  }

  /** Convert a SequencedMessage proto to a SequencedMessage. */
  public static SequencedMessage fromProto(
      com.google.cloud.pubsublite.proto.SequencedMessage proto) {
    Preconditions.checkArgument(proto.getSizeBytes() >= 0);
    return of(
        Message.fromProto(proto.getMessage()),
        proto.getPublishTime(),
        Offset.of(proto.getCursor().getOffset()),
        proto.getSizeBytes());
  }

  /** Convert to a SequencedMessage proto. */
  public com.google.cloud.pubsublite.proto.SequencedMessage toProto() {
    return com.google.cloud.pubsublite.proto.SequencedMessage.newBuilder()
        .setMessage(message().toProto())
        .setCursor(Cursor.newBuilder().setOffset(offset().value()))
        .setPublishTime(publishTime())
        .setSizeBytes(byteSize())
        .build();
  }

  /** The underlying user Message. */
  public abstract Message message();

  /** The time when the message was published. */
  public abstract Timestamp publishTime();

  /** The offset for this message. */
  public abstract Offset offset();

  /** The amount of quota bytes this message counts for. */
  public abstract long byteSize();
}
