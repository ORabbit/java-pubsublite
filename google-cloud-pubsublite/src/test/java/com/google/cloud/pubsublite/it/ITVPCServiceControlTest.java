/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// DO NOT MODIFY! THIS FILE IS AUTO-GENERATED.
// This file is auto-generated on 28 Aug 20 20:46 EDT.

package com.google.cloud.pubsublite.it;

import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.cloud.pubsublite.proto.*;
import com.google.cloud.pubsublite.v1.*;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by Google")
public class ITVPCServiceControlTest {
  static final String PROJECT_INSIDE = System.getenv("PROJECT_ID");
  static final String PROJECT_OUTSIDE =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT_NUMBER");
  static final String IS_INSIDE_VPCSC = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");
  private static final Logger logger = Logger.getLogger(ITVPCServiceControlTest.class.getName());

  private static Exception getError(Callable callable) {
    try {
      callable.call();
    } catch (Exception e) {
      logger.log(Level.INFO, e.getMessage());
      return e;
    }
    return null;
  }

  private static void doTest(Callable delayedInside, Callable delayedOutside) {
    if ((IS_INSIDE_VPCSC != null) && (IS_INSIDE_VPCSC.equalsIgnoreCase("true"))) {
      logger.log(Level.INFO, "inside perimeter");
      Exception e = getError(delayedOutside);
      Assert.assertTrue(
          PermissionDeniedException.class.isInstance(e)
              && e.getMessage().contains("Request is prohibited by organization's policy"));
      e = getError(delayedInside);
      Assert.assertFalse(
          PermissionDeniedException.class.isInstance(e)
              && e.getMessage().contains("Request is prohibited by organization's policy"));
    } else {
      logger.log(Level.INFO, "outside perimeter");
      Exception e = getError(delayedOutside);
      Assert.assertFalse(
          PermissionDeniedException.class.isInstance(e)
              && e.getMessage().contains("Request is prohibited by organization's policy"));
      e = getError(delayedInside);
      Assert.assertTrue(
          PermissionDeniedException.class.isInstance(e)
              && e.getMessage().contains("Request is prohibited by organization's policy"));
    }
  }

  @BeforeClass
  public static void setUpClass() {
    Assume.assumeTrue(
        "Missing environment variable: PROJECT_ID",
        PROJECT_INSIDE != null && !PROJECT_INSIDE.isEmpty());
    Assume.assumeTrue(
        "Missing environment variable: GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT_NUMBER",
        PROJECT_OUTSIDE != null && !PROJECT_OUTSIDE.isEmpty());
  }

  @Test
  @SuppressWarnings("all")
  public void createSubscriptionTest() throws Exception {
    System.out.println("blah\nblah\nblah\nblah\nblah");
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            LocationName nameInside = LocationName.of(PROJECT_INSIDE, "MockLocation");
            logger.log(Level.INFO, "createSubscriptionTest: requesting {0}", nameInside);
            client.createSubscription(
                CreateSubscriptionRequest.newBuilder().setParent(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            LocationName nameOutside = LocationName.of(PROJECT_OUTSIDE, "MockLocation");
            logger.log(Level.INFO, "createSubscriptionTest: requesting {0}", nameOutside);
            client.createSubscription(
                CreateSubscriptionRequest.newBuilder().setParent(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createTopicTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            LocationName nameInside = LocationName.of(PROJECT_INSIDE, "MockLocation");
            logger.log(Level.INFO, "createTopicTest: requesting {0}", nameInside);
            client.createTopic(
                CreateTopicRequest.newBuilder().setParent(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            LocationName nameOutside = LocationName.of(PROJECT_OUTSIDE, "MockLocation");
            logger.log(Level.INFO, "createTopicTest: requesting {0}", nameOutside);
            client.createTopic(
                CreateTopicRequest.newBuilder().setParent(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSubscriptionTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            SubscriptionName nameInside =
                SubscriptionName.of(PROJECT_INSIDE, "MockLocation", "MockSubscription");
            logger.log(Level.INFO, "deleteSubscriptionTest: requesting {0}", nameInside);
            client.deleteSubscription(
                DeleteSubscriptionRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            SubscriptionName nameOutside =
                SubscriptionName.of(PROJECT_OUTSIDE, "MockLocation", "MockSubscription");
            logger.log(Level.INFO, "deleteSubscriptionTest: requesting {0}", nameOutside);
            client.deleteSubscription(
                DeleteSubscriptionRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTopicTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameInside = TopicName.of(PROJECT_INSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "deleteTopicTest: requesting {0}", nameInside);
            client.deleteTopic(
                DeleteTopicRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameOutside = TopicName.of(PROJECT_OUTSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "deleteTopicTest: requesting {0}", nameOutside);
            client.deleteTopic(
                DeleteTopicRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSubscriptionTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            SubscriptionName nameInside =
                SubscriptionName.of(PROJECT_INSIDE, "MockLocation", "MockSubscription");
            logger.log(Level.INFO, "getSubscriptionTest: requesting {0}", nameInside);
            client.getSubscription(
                GetSubscriptionRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            SubscriptionName nameOutside =
                SubscriptionName.of(PROJECT_OUTSIDE, "MockLocation", "MockSubscription");
            logger.log(Level.INFO, "getSubscriptionTest: requesting {0}", nameOutside);
            client.getSubscription(
                GetSubscriptionRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTopicTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameInside = TopicName.of(PROJECT_INSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "getTopicTest: requesting {0}", nameInside);
            client.getTopic(GetTopicRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameOutside = TopicName.of(PROJECT_OUTSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "getTopicTest: requesting {0}", nameOutside);
            client.getTopic(GetTopicRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTopicPartitionsTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameInside = TopicName.of(PROJECT_INSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "getTopicPartitionsTest: requesting {0}", nameInside);
            client.getTopicPartitions(
                GetTopicPartitionsRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameOutside = TopicName.of(PROJECT_OUTSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "getTopicPartitionsTest: requesting {0}", nameOutside);
            client.getTopicPartitions(
                GetTopicPartitionsRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listSubscriptionsTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            LocationName nameInside = LocationName.of(PROJECT_INSIDE, "MockLocation");
            logger.log(Level.INFO, "listSubscriptionsTest: requesting {0}", nameInside);
            client.listSubscriptions(
                ListSubscriptionsRequest.newBuilder().setParent(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            LocationName nameOutside = LocationName.of(PROJECT_OUTSIDE, "MockLocation");
            logger.log(Level.INFO, "listSubscriptionsTest: requesting {0}", nameOutside);
            client.listSubscriptions(
                ListSubscriptionsRequest.newBuilder().setParent(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTopicSubscriptionsTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameInside = TopicName.of(PROJECT_INSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "listTopicSubscriptionsTest: requesting {0}", nameInside);
            client.listTopicSubscriptions(
                ListTopicSubscriptionsRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameOutside = TopicName.of(PROJECT_OUTSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "listTopicSubscriptionsTest: requesting {0}", nameOutside);
            client.listTopicSubscriptions(
                ListTopicSubscriptionsRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTopicsTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            LocationName nameInside = LocationName.of(PROJECT_INSIDE, "MockLocation");
            logger.log(Level.INFO, "listTopicsTest: requesting {0}", nameInside);
            client.listTopics(
                ListTopicsRequest.newBuilder().setParent(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            LocationName nameOutside = LocationName.of(PROJECT_OUTSIDE, "MockLocation");
            logger.log(Level.INFO, "listTopicsTest: requesting {0}", nameOutside);
            client.listTopics(
                ListTopicsRequest.newBuilder().setParent(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSubscriptionTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            SubscriptionName nameInside =
                SubscriptionName.of(PROJECT_INSIDE, "MockLocation", "MockSubscription");
            logger.log(Level.INFO, "updateSubscriptionTest: requesting {0}", nameInside);
            client.updateSubscription(
                UpdateSubscriptionRequest.newBuilder()
                    .setSubscription(
                        Subscription.newBuilder().setName(nameInside.toString()).build())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            SubscriptionName nameOutside =
                SubscriptionName.of(PROJECT_OUTSIDE, "MockLocation", "MockSubscription");
            logger.log(Level.INFO, "updateSubscriptionTest: requesting {0}", nameOutside);
            client.updateSubscription(
                UpdateSubscriptionRequest.newBuilder()
                    .setSubscription(
                        Subscription.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTopicTest() throws Exception {
    final AdminServiceClient client = AdminServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameInside = TopicName.of(PROJECT_INSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "updateTopicTest: requesting {0}", nameInside);
            client.updateTopic(
                UpdateTopicRequest.newBuilder()
                    .setTopic(Topic.newBuilder().setName(nameInside.toString()).build())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            TopicName nameOutside = TopicName.of(PROJECT_OUTSIDE, "MockLocation", "MockTopic");
            logger.log(Level.INFO, "updateTopicTest: requesting {0}", nameOutside);
            client.updateTopic(
                UpdateTopicRequest.newBuilder()
                    .setTopic(Topic.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPartitionCursorsTest() throws Exception {
    final CursorServiceClient client = CursorServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            SubscriptionName nameInside =
                SubscriptionName.of(PROJECT_INSIDE, "MockLocation", "MockSubscription");
            logger.log(Level.INFO, "listPartitionCursorsTest: requesting {0}", nameInside);
            client.listPartitionCursors(
                ListPartitionCursorsRequest.newBuilder().setParent(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            SubscriptionName nameOutside =
                SubscriptionName.of(PROJECT_OUTSIDE, "MockLocation", "MockSubscription");
            logger.log(Level.INFO, "listPartitionCursorsTest: requesting {0}", nameOutside);
            client.listPartitionCursors(
                ListPartitionCursorsRequest.newBuilder().setParent(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }
}
