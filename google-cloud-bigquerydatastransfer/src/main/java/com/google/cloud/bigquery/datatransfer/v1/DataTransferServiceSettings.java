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

import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListDataSourcesPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferConfigsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferLogsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferRunsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigquery.datatransfer.v1.stub.DataTransferServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DataTransferServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigquerydatatransfer.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDataSource to 30 seconds:
 *
 * <pre>
 * <code>
 * DataTransferServiceSettings.Builder dataTransferServiceSettingsBuilder =
 *     DataTransferServiceSettings.newBuilder();
 * dataTransferServiceSettingsBuilder.getDataSourceSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DataTransferServiceSettings dataTransferServiceSettings = dataTransferServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DataTransferServiceSettings extends ClientSettings<DataTransferServiceSettings> {
  /** Returns the object with the settings used for calls to getDataSource. */
  public UnaryCallSettings<GetDataSourceRequest, DataSource> getDataSourceSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).getDataSourceSettings();
  }

  /** Returns the object with the settings used for calls to listDataSources. */
  public PagedCallSettings<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      listDataSourcesSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).listDataSourcesSettings();
  }

  /** Returns the object with the settings used for calls to createTransferConfig. */
  public UnaryCallSettings<CreateTransferConfigRequest, TransferConfig>
      createTransferConfigSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).createTransferConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateTransferConfig. */
  public UnaryCallSettings<UpdateTransferConfigRequest, TransferConfig>
      updateTransferConfigSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).updateTransferConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteTransferConfig. */
  public UnaryCallSettings<DeleteTransferConfigRequest, Empty> deleteTransferConfigSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).deleteTransferConfigSettings();
  }

  /** Returns the object with the settings used for calls to getTransferConfig. */
  public UnaryCallSettings<GetTransferConfigRequest, TransferConfig> getTransferConfigSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).getTransferConfigSettings();
  }

  /** Returns the object with the settings used for calls to listTransferConfigs. */
  public PagedCallSettings<
          ListTransferConfigsRequest, ListTransferConfigsResponse, ListTransferConfigsPagedResponse>
      listTransferConfigsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).listTransferConfigsSettings();
  }

  /** Returns the object with the settings used for calls to scheduleTransferRuns. */
  public UnaryCallSettings<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).scheduleTransferRunsSettings();
  }

  /** Returns the object with the settings used for calls to getTransferRun. */
  public UnaryCallSettings<GetTransferRunRequest, TransferRun> getTransferRunSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).getTransferRunSettings();
  }

  /** Returns the object with the settings used for calls to deleteTransferRun. */
  public UnaryCallSettings<DeleteTransferRunRequest, Empty> deleteTransferRunSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).deleteTransferRunSettings();
  }

  /** Returns the object with the settings used for calls to listTransferRuns. */
  public PagedCallSettings<
          ListTransferRunsRequest, ListTransferRunsResponse, ListTransferRunsPagedResponse>
      listTransferRunsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).listTransferRunsSettings();
  }

  /** Returns the object with the settings used for calls to listTransferLogs. */
  public PagedCallSettings<
          ListTransferLogsRequest, ListTransferLogsResponse, ListTransferLogsPagedResponse>
      listTransferLogsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).listTransferLogsSettings();
  }

  /** Returns the object with the settings used for calls to checkValidCreds. */
  public UnaryCallSettings<CheckValidCredsRequest, CheckValidCredsResponse>
      checkValidCredsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).checkValidCredsSettings();
  }

  /** Returns the object with the settings used for calls to startManualTransferRuns. */
  public UnaryCallSettings<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).startManualTransferRunsSettings();
  }

  public static final DataTransferServiceSettings create(DataTransferServiceStubSettings stub)
      throws IOException {
    return new DataTransferServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataTransferServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataTransferServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataTransferServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataTransferServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataTransferServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataTransferServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataTransferServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected DataTransferServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataTransferServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataTransferServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(DataTransferServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(DataTransferServiceStubSettings.newBuilder());
    }

    protected Builder(DataTransferServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataTransferServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public DataTransferServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataTransferServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getDataSource. */
    public UnaryCallSettings.Builder<GetDataSourceRequest, DataSource> getDataSourceSettings() {
      return getStubSettingsBuilder().getDataSourceSettings();
    }

    /** Returns the builder for the settings used for calls to listDataSources. */
    public PagedCallSettings.Builder<
            ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
        listDataSourcesSettings() {
      return getStubSettingsBuilder().listDataSourcesSettings();
    }

    /** Returns the builder for the settings used for calls to createTransferConfig. */
    public UnaryCallSettings.Builder<CreateTransferConfigRequest, TransferConfig>
        createTransferConfigSettings() {
      return getStubSettingsBuilder().createTransferConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateTransferConfig. */
    public UnaryCallSettings.Builder<UpdateTransferConfigRequest, TransferConfig>
        updateTransferConfigSettings() {
      return getStubSettingsBuilder().updateTransferConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTransferConfig. */
    public UnaryCallSettings.Builder<DeleteTransferConfigRequest, Empty>
        deleteTransferConfigSettings() {
      return getStubSettingsBuilder().deleteTransferConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getTransferConfig. */
    public UnaryCallSettings.Builder<GetTransferConfigRequest, TransferConfig>
        getTransferConfigSettings() {
      return getStubSettingsBuilder().getTransferConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listTransferConfigs. */
    public PagedCallSettings.Builder<
            ListTransferConfigsRequest, ListTransferConfigsResponse,
            ListTransferConfigsPagedResponse>
        listTransferConfigsSettings() {
      return getStubSettingsBuilder().listTransferConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to scheduleTransferRuns. */
    public UnaryCallSettings.Builder<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
        scheduleTransferRunsSettings() {
      return getStubSettingsBuilder().scheduleTransferRunsSettings();
    }

    /** Returns the builder for the settings used for calls to getTransferRun. */
    public UnaryCallSettings.Builder<GetTransferRunRequest, TransferRun> getTransferRunSettings() {
      return getStubSettingsBuilder().getTransferRunSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTransferRun. */
    public UnaryCallSettings.Builder<DeleteTransferRunRequest, Empty> deleteTransferRunSettings() {
      return getStubSettingsBuilder().deleteTransferRunSettings();
    }

    /** Returns the builder for the settings used for calls to listTransferRuns. */
    public PagedCallSettings.Builder<
            ListTransferRunsRequest, ListTransferRunsResponse, ListTransferRunsPagedResponse>
        listTransferRunsSettings() {
      return getStubSettingsBuilder().listTransferRunsSettings();
    }

    /** Returns the builder for the settings used for calls to listTransferLogs. */
    public PagedCallSettings.Builder<
            ListTransferLogsRequest, ListTransferLogsResponse, ListTransferLogsPagedResponse>
        listTransferLogsSettings() {
      return getStubSettingsBuilder().listTransferLogsSettings();
    }

    /** Returns the builder for the settings used for calls to checkValidCreds. */
    public UnaryCallSettings.Builder<CheckValidCredsRequest, CheckValidCredsResponse>
        checkValidCredsSettings() {
      return getStubSettingsBuilder().checkValidCredsSettings();
    }

    /** Returns the builder for the settings used for calls to startManualTransferRuns. */
    public UnaryCallSettings.Builder<
            StartManualTransferRunsRequest, StartManualTransferRunsResponse>
        startManualTransferRunsSettings() {
      return getStubSettingsBuilder().startManualTransferRunsSettings();
    }

    @Override
    public DataTransferServiceSettings build() throws IOException {
      return new DataTransferServiceSettings(this);
    }
  }
}
