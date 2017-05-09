package com.zhu8fei.framework.test.commons.mybatis;

import com.alibaba.fastjson.JSON;
import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataJsonBean;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import org.junit.Test;

/**
 * Created by zhu8fei on 2017/5/8.
 */
@MarkTestTarget(MethodTest.class)
public class ExpectBeanJunitTest extends BaseJunitTest {
    @Test
    public void jsonFormat() {
        String json = " {" +
                " \"prepare\":[{" +
                " \"tableName\":\"prepare_table\"," +
                " \"columns\":[\"column1\",\"column2\"]," +
                " \"rows\":[[\"value1\",\"value2\"],[\"value1\",\"value2\"]  ]" +
                " }  ], " +
                "   \"expect\":[{" +
                " \"tableName\":\"expect_table\"," +
                " \"columns\":[\"column1\",\"column2\"]," +
                " \"rows\" :[[\"value1\",\"value2\"],[\"value1\",\"value2\"]  ]" +
                "   } ]" +
                "  }";

        DataJsonBean bean = JSON.parseObject(json, DataJsonBean.class);
        logger.info(bean.toString());
    }

}