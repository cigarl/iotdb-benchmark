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

package cn.edu.tsinghua.iotdb.benchmark.workload;

import cn.edu.tsinghua.iotdb.benchmark.workload.ingestion.Batch;
import cn.edu.tsinghua.iotdb.benchmark.workload.query.impl.AggRangeQuery;
import cn.edu.tsinghua.iotdb.benchmark.workload.query.impl.AggRangeValueQuery;
import cn.edu.tsinghua.iotdb.benchmark.workload.query.impl.AggValueQuery;
import cn.edu.tsinghua.iotdb.benchmark.workload.query.impl.GroupByQuery;
import cn.edu.tsinghua.iotdb.benchmark.workload.query.impl.LatestPointQuery;
import cn.edu.tsinghua.iotdb.benchmark.workload.query.impl.PreciseQuery;
import cn.edu.tsinghua.iotdb.benchmark.workload.query.impl.RangeQuery;
import cn.edu.tsinghua.iotdb.benchmark.workload.query.impl.ValueRangeQuery;
import cn.edu.tsinghua.iotdb.benchmark.workload.schema.DeviceSchema;

public interface IWorkload {

  /**
   * Insert one batch into database, NOTICE: every row contains data from all sensors
   *
   * @param deviceSchema
   * @param loopIndex
   * @return
   * @throws WorkloadException
   */
  Batch getOneBatch(DeviceSchema deviceSchema, long loopIndex) throws WorkloadException;

  /**
   * Insert one batch into database, NOTICE: every row contains data from sensor which index is
   * colIndex
   *
   * @param deviceSchema
   * @param loopIndex
   * @param colIndex
   * @return
   * @throws WorkloadException
   */
  Batch getOneBatch(DeviceSchema deviceSchema, long loopIndex, int colIndex)
      throws WorkloadException;

  /**
   * Get precise query Eg. select v1... from data where time = ? and device in ?
   *
   * @return
   * @throws WorkloadException
   */
  PreciseQuery getPreciseQuery() throws WorkloadException;

  /**
   * Get range query Eg. select v1... from data where time > ? and time < ? and device in ?
   *
   * @return
   * @throws WorkloadException
   */
  RangeQuery getRangeQuery() throws WorkloadException;

  /**
   * Get value range query Eg. select v1... from data where time > ? and time < ? and v1 > ? and
   * device in ?
   *
   * @return
   * @throws WorkloadException
   */
  ValueRangeQuery getValueRangeQuery() throws WorkloadException;

  /**
   * Get aggregate range query Eg. select func(v1)... from data where device in ? and time > ? and
   * time < ?
   *
   * @return
   * @throws WorkloadException
   */
  AggRangeQuery getAggRangeQuery() throws WorkloadException;

  /**
   * Get aggregate value query Eg. select func(v1)... from data where device in ? and value > ?
   *
   * @return
   * @throws WorkloadException
   */
  AggValueQuery getAggValueQuery() throws WorkloadException;

  /**
   * Get aggregate range value query Eg. select func(v1)... from data where device in ? and value >
   * ? and time > ? and time < ?
   *
   * @return
   * @throws WorkloadException
   */
  AggRangeValueQuery getAggRangeValueQuery() throws WorkloadException;

  /**
   * Get group by query Now only sentences with one time interval can be generated
   *
   * @return
   * @throws WorkloadException
   */
  GroupByQuery getGroupByQuery() throws WorkloadException;

  /**
   * Get latest point query Eg. select time, v1... where device = ? and time = max(time)
   *
   * @return
   * @throws WorkloadException
   */
  LatestPointQuery getLatestPointQuery() throws WorkloadException;
}
