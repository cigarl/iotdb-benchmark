/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package cn.edu.tsinghua.iotdb.benchmark.measurement.persistence.none;

import cn.edu.tsinghua.iotdb.benchmark.measurement.enums.SystemMetrics;
import cn.edu.tsinghua.iotdb.benchmark.measurement.persistence.ITestDataPersistence;

import java.util.Map;

public class NoneRecorder implements ITestDataPersistence {

  @Override
  public void insertSystemMetrics(Map<SystemMetrics, Float> systemMetricsMap) {
    // DO nothing
  }

  @Override
  public void saveTestConfig() {
    // DO nothing
  }

  @Override
  public void saveOperationResult(
      String operation, int okPoint, int failPoint, double latency, String remark) {
    // DO nothing
  }

  @Override
  public void saveResult(String operation, String key, String value) {
    // DO nothing
  }

  @Override
  public void close() {
    // DO nothing
  }
}
