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

package com.example.bigquerydatatransfer;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.ProjectName;
import com.google.cloud.bigquery.datatransfer.v1.ScheduleOptions;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Clock;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

public class ScheduleBackFillIT {

  private static final Logger LOG = Logger.getLogger(ScheduleBackFillIT.class.getName());
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private BigQuery bigquery;
  private ByteArrayOutputStream bout;
  private String name;
  private String displayName;
  private String datasetName;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    displayName = "MY_SCHEDULE_BACKFILL_NAME_TEST_" + ID;
    datasetName = "MY_DATASET_BACKFILL_NAME_TEST_" + ID;
    // create a temporary dataset
    bigquery = BigQueryOptions.getDefaultInstance().getService();
    bigquery.create(DatasetInfo.of(datasetName));

    ServiceAccountCredentials credentials =
        (ServiceAccountCredentials) ServiceAccountCredentials.getApplicationDefault();
    // create a scheduled query
    String query =
        "SELECT CURRENT_TIMESTAMP() as current_time, @run_time as intended_run_time, "
            + "@run_date as intended_run_date, 17 as some_integer";
    String destinationTableName = "MY_DESTINATION_TABLE_" + ID + "_{run_date}";
    Map<String, Value> params = new HashMap<>();
    params.put("query", Value.newBuilder().setStringValue(query).build());
    params.put(
        "destination_table_name_template",
        Value.newBuilder().setStringValue(destinationTableName).build());
    params.put("write_disposition", Value.newBuilder().setStringValue("WRITE_TRUNCATE").build());
    params.put("partitioning_field", Value.newBuilder().setStringValue("").build());
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setDestinationDatasetId(datasetName)
            .setDisplayName(displayName)
            .setDataSourceId("scheduled_query")
            .setParams(Struct.newBuilder().putAllFields(params).build())
            .setSchedule("every 24 hours")
            .build();
    try (DataTransferServiceClient client = DataTransferServiceClient.create()) {
      ProjectName parent = ProjectName.of(PROJECT_ID);
      CreateTransferConfigRequest request =
          CreateTransferConfigRequest.newBuilder()
              .setParent(parent.toString())
              .setTransferConfig(transferConfig)
              .setServiceAccountName(credentials.getClientEmail())
              .build();
      name = client.createTransferConfig(request).getName();
      System.out.println("Scheduled query created successfully :" + name);
      System.out.println("Service account : " + credentials.getClientEmail());
    }
  }

  @After
  public void tearDown() throws IOException {
    // delete scheduled query that was just created
    DeleteScheduledQuery.deleteScheduledQuery(name);
    // delete a temporary dataset
    bigquery.delete(datasetName, BigQuery.DatasetDeleteOption.deleteContents());
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    LOG.log(Level.INFO, bout.toString());
  }

  @Test
  public void testScheduleBackFill() throws IOException {
    Clock clock = Clock.systemDefaultZone();
    Instant instant = clock.instant();
    Timestamp startDate =
        Timestamp.newBuilder()
            .setSeconds(instant.minus(5, ChronoUnit.DAYS).getEpochSecond())
            .setNanos(instant.minus(5, ChronoUnit.DAYS).getNano())
            .build();
    Timestamp endDate =
        Timestamp.newBuilder()
            .setSeconds(instant.minus(2, ChronoUnit.DAYS).getEpochSecond())
            .setNanos(instant.minus(2, ChronoUnit.DAYS).getNano())
            .build();
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setName(name)
            .setScheduleOptions(
                ScheduleOptions.newBuilder().setStartTime(startDate).setEndTime(endDate).build())
            .build();
    FieldMask updateMask = FieldMaskUtil.fromStringList(ImmutableList.of("start_time", "end_time"));
    ScheduleBackFill.scheduleBackFill(transferConfig, updateMask);
    assertThat(bout.toString()).contains("Schedule backfill updated successfully :");
  }
}
