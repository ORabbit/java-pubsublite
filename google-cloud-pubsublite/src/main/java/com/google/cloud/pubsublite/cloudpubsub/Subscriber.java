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

package com.google.cloud.pubsublite.cloudpubsub;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.pubsub.v1.SubscriberInterface;

/** A sub-interface of {@link com.google.cloud.pubsub.v1.SubscriberInterface}. */
public interface Subscriber extends SubscriberInterface {
  /** Create a new Pub/Sub Lite subscriber using the provided settings. */
  static Subscriber create(SubscriberSettings settings) throws ApiException {
    return settings.instantiate();
  }
}
