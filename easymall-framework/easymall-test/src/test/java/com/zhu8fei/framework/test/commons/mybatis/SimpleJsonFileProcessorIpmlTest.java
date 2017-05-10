package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.BaseTransactionalSpringTest;
import com.zhu8fei.framework.test.commons.annotation.DataSet;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.PrepareAndExpectSqlTest;
import org.junit.Test;

/**
 * Created by zhu8fei on 2017/5/9.
 */
@MarkTestTarget(PrepareAndExpectSqlTest.class)
public class SimpleJsonFileProcessorIpmlTest extends BaseTransactionalSpringTest {

    @DataSet(value = "{" +
         "     \"prepare\": [{" +
         "          \"tableName\": \"u_user\"," +
         "          \"columns\": [ \"name\", \"real_name\"]," +
         "          \"rows\": [" +
         "               [\"name1\", \"real_name1\"]," +
         "               [\"name2\", \"real_name2\"]," +
         "          ]" +
         "     }]," +
         "     \"expect\": [{" +
         "          \"tableName\": \"u_user\"," +
         "          \"columns\": [\"name\", \"real_name\"]," +
         "          \"rows\": [" +
         "               [\"name1\", \"real_name1\"]," +
         "               [\"name2\", \"real_name2\"]," +
         "          ]," +
         "          \"param\": {" +
         "               \"real_name\": \"real_name%\"," +
         "          }" +
         "     }]" +
         "}",log=true)
    @Test
    public void DataSetAnnotationTest() {
        logger.info(" 谁知道呢. ");
    }
}