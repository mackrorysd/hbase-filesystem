/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hbase.oss;

import java.net.URI;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HBaseObjectStoreSemanticsTest {
  public static final Logger LOG =
        LoggerFactory.getLogger(HBaseObjectStoreSemanticsTest.class);

  protected HBaseObjectStoreSemantics hboss = null;

  public Path testPathRoot() {
    return TestUtils.testPathRoot(hboss);
  }

  public Path testPath(String path) {
    return TestUtils.testPath(hboss, path);
  }

  public Path testPath(Path path) {
    return TestUtils.testPath(hboss, path);
  }

  @Before
  public void setup() throws Exception {
    Configuration conf = new Configuration();
    hboss = TestUtils.getFileSystem(conf);
    hboss.mkdirs(testPathRoot());
  }

  @After
  public void tearDown() throws Exception {
    TestUtils.cleanup(hboss);
  }
}
