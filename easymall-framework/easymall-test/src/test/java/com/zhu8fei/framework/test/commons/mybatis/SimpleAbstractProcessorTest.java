package com.zhu8fei.framework.test.commons.mybatis;

import com.alibaba.fastjson.JSON;
import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataSetBean;
import com.zhu8fei.framework.test.commons.mybatis.bean.SimpleTable;
import com.zhu8fei.framework.test.commons.mybatis.mapper.SimpleMybatisMapper;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.PrepareAndExpectSqlTest;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;


/**
 * Created by zhu8fei on 2017/5/12.
 */
@MarkTestTarget(PrepareAndExpectSqlTest.class)
public class SimpleAbstractProcessorTest extends BaseJunitTest {

    @Test
    public void insertPrepareData() throws Exception {
        // 练习mock和蹭覆盖率的..
        // when(SimpleAbstractProcessor.class,"insert");
        SimpleAbstractProcessor simpleAbstractProcessor = spy(SimpleAbstractProcessor.class);
        Class<SimpleAbstractProcessor> clz = SimpleAbstractProcessor.class;

        Method insert = clz.getDeclaredMethod("insert", DataSetBean.class);
        insert.setAccessible(true);
        DataSetBean dataSetBean = new DataSetBean();
        Object obj = null;
        // 参数空
        insert.invoke(simpleAbstractProcessor, obj);
        // 比对条件空
        insert.invoke(simpleAbstractProcessor, dataSetBean);

        // 比对结果测试
        Method expectData = clz.getDeclaredMethod("expectData", DataSetBean.class);
        expectData.setAccessible(true);
        // 参数空
        expectData.invoke(simpleAbstractProcessor, obj);
        // 比对条件空
        expectData.invoke(simpleAbstractProcessor, dataSetBean);
        // mock simpleMybatisMapper
        Field fieldMapper = clz.getDeclaredField("simpleMybatisMapper");
        fieldMapper.setAccessible(true);
        SimpleMybatisMapper simpleMybatisMapper = mock(SimpleMybatisMapper.class);
        fieldMapper.set(simpleAbstractProcessor, simpleMybatisMapper);
        // mock数据库没有返回时,
        String json = " {" +
                " \"prepare\":[{" +
                " \"tableName\":\"prepare_table\"," +
                " \"columns\":[\"column1\",\"column2\"]," +
                " \"rows\":[[\"value1\",\"value2\"],[\"value1\",\"value2\"]  ]" +
                " }  ], " +
                "   \"expect\":[{" +
                " \"tableName\":\"expect_table\"," +
                " \"columns\":[\"column1\",\"column2\"]," +
                " \"rows\" :[ ]" +
                "   } ]" +
                "  }";
        dataSetBean = JSON.parseObject(json, DataSetBean.class);
        //此时应该返回 true
        boolean result = (boolean) expectData.invoke(simpleAbstractProcessor, dataSetBean);
        Assert.assertEquals(result, true);
        // mock数据库有返回值时


        // Assert.assertEquals(result, false);
    }

    @Test
    public void cmpareResult() throws Exception {

        SimpleAbstractProcessor simpleAbstractProcessor = spy(SimpleAbstractProcessor.class);
        Class<SimpleAbstractProcessor> clz = SimpleAbstractProcessor.class;
        Field fieldMapper = clz.getDeclaredField("simpleMybatisMapper");
        fieldMapper.setAccessible(true);
        SimpleMybatisMapper simpleMybatisMapper = mock(SimpleMybatisMapper.class);
        fieldMapper.set(simpleAbstractProcessor, simpleMybatisMapper);
        String target = "[{\n" + "\t\"column1\":null,\"column2\":\"value2\"\n" + "}" +
                ",{\n" + "\t\"column1\":\"value1\",\"column2\":\"value3\"\n" + "}" +
                ",{\n" + "\t\"column1\":\"value1\",\"column2\":\"value4\"\n" + "},]";
        List<Map<String, String>> dataResult = JSON.<List<Map<String, String>>>parseObject(target, List.class);
        // 当mapper调用select 方法 时,返回 dataResult
        when(simpleMybatisMapper.select(any(SimpleTable.class))).thenReturn(dataResult);
        Method expectData = clz.getDeclaredMethod("expectData", DataSetBean.class);
        expectData.setAccessible(true);
        String json = "{\"prepare\":[{" +
                " \"tableName\":\"prepare_table\"," +
                " \"columns\":[\"column1\",\"column2\"]," +
                " \"rows\":[[\"value1\",\"value2\"],[\"value1\",\"value2\"]]" +
                " }], " +
                " \"expect\":[{" +
                " \"tableName\":\"expect_table\"," +
                " \"columns\":[\"column1\",\"column2\"]," +
                " \"rows\" :[[\"value1\",null],[\"value1\",\"ds\"],[\"value1\",\"value5\"],[\"value1\",\"value4\"]]" +
                " }] }";
        DataSetBean dataSetBean = JSON.parseObject(json, DataSetBean.class);
        boolean result = (boolean) expectData.invoke(simpleAbstractProcessor, dataSetBean);
        Assert.assertEquals(result , false);
    }

}