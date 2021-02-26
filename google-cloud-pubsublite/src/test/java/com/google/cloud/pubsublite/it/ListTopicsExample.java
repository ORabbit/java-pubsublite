/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pubsublite;

// [START pubsublite_list_topics]
import com.google.cloud.pubsublite.AdminClient;
import com.google.cloud.pubsublite.AdminClientSettings;
import com.google.cloud.pubsublite.CloudRegion;
import com.google.cloud.pubsublite.CloudZone;
import com.google.cloud.pubsublite.LocationPath;
import com.google.cloud.pubsublite.ProjectId;
import com.google.cloud.pubsublite.proto.Topic;
import java.util.List;

public class ListTopicsExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String cloudRegion = "your-cloud-region";
    char zoneId = 'b';
    long projectNumber = Long.parseLong("123456789");

    // listTopicsExample(cloudRegion, zoneId, projectNumber);
  }

  public static void listTopicsExample(String cloudRegion, char zoneId, String projectNumber)
      throws Exception {

    AdminClientSettings adminClientSettings =
        AdminClientSettings.newBuilder().setRegion(CloudRegion.of(cloudRegion)).build();

    LocationPath locationPath =
        LocationPath.newBuilder()
            .setProject(ProjectId.of(projectNumber))
            .setLocation(CloudZone.of(CloudRegion.of(cloudRegion), zoneId))
            .build();

    try (AdminClient adminClient = AdminClient.create(adminClientSettings)) {
      List<Topic> topics = adminClient.listTopics(locationPath).get();
      for (Topic topic : topics) {
        System.out.println(topic.getAllFields());
      }
      System.out.println(topics.size() + " topic(s) listed.");
    }
  }
}
// [END pubsublite_list_topics]
