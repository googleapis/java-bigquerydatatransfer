# Copyright 2019 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

"""This script is used to synthesize generated parts of this library."""

import synthtool.gcp as gcp
import synthtool.languages.java as java

AUTOSYNTH_MULTIPLE_COMMITS = True

gapic = gcp.GAPICGenerator()

service = 'bigquery-datatransfer'
destination_name = 'bigquerydatatransfer'
versions = ['v1']

for version in versions:
  java.bazel_library(
      service='bigquery-datatransfer',
      version=version,
      proto_path=f'google/cloud/bigquery/datatransfer/{version}',
      bazel_target=f'//google/cloud/bigquery/datatransfer/{version}:google-cloud-bigquery-datatransfer-{version}-java',
      destination_name='bigquerydatatransfer',
  )

java.common_templates(excludes=[
    '.kokoro/build.sh',
    '.kokoro/nightly/samples.cfg',
    '.kokoro/presubmit/samples.cfg',
])
