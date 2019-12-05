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
package com.google.cloud.bigquery.datatransfer.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceGrpc.DataTransferServiceImplBase;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockDataTransferServiceImpl extends DataTransferServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataTransferServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void getDataSource(
      GetDataSourceRequest request, StreamObserver<DataSource> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DataSource) {
      requests.add(request);
      responseObserver.onNext((DataSource) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listDataSources(
      ListDataSourcesRequest request, StreamObserver<ListDataSourcesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListDataSourcesResponse) {
      requests.add(request);
      responseObserver.onNext((ListDataSourcesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createTransferConfig(
      CreateTransferConfigRequest request, StreamObserver<TransferConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TransferConfig) {
      requests.add(request);
      responseObserver.onNext((TransferConfig) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateTransferConfig(
      UpdateTransferConfigRequest request, StreamObserver<TransferConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TransferConfig) {
      requests.add(request);
      responseObserver.onNext((TransferConfig) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteTransferConfig(
      DeleteTransferConfigRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getTransferConfig(
      GetTransferConfigRequest request, StreamObserver<TransferConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TransferConfig) {
      requests.add(request);
      responseObserver.onNext((TransferConfig) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listTransferConfigs(
      ListTransferConfigsRequest request,
      StreamObserver<ListTransferConfigsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListTransferConfigsResponse) {
      requests.add(request);
      responseObserver.onNext((ListTransferConfigsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void scheduleTransferRuns(
      ScheduleTransferRunsRequest request,
      StreamObserver<ScheduleTransferRunsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ScheduleTransferRunsResponse) {
      requests.add(request);
      responseObserver.onNext((ScheduleTransferRunsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void startManualTransferRuns(
      StartManualTransferRunsRequest request,
      StreamObserver<StartManualTransferRunsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof StartManualTransferRunsResponse) {
      requests.add(request);
      responseObserver.onNext((StartManualTransferRunsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getTransferRun(
      GetTransferRunRequest request, StreamObserver<TransferRun> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TransferRun) {
      requests.add(request);
      responseObserver.onNext((TransferRun) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteTransferRun(
      DeleteTransferRunRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listTransferRuns(
      ListTransferRunsRequest request, StreamObserver<ListTransferRunsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListTransferRunsResponse) {
      requests.add(request);
      responseObserver.onNext((ListTransferRunsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listTransferLogs(
      ListTransferLogsRequest request, StreamObserver<ListTransferLogsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListTransferLogsResponse) {
      requests.add(request);
      responseObserver.onNext((ListTransferLogsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void checkValidCreds(
      CheckValidCredsRequest request, StreamObserver<CheckValidCredsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CheckValidCredsResponse) {
      requests.add(request);
      responseObserver.onNext((CheckValidCredsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
