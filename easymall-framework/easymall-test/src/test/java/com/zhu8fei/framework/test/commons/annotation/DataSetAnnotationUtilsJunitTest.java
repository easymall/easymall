package com.zhu8fei.framework.test.commons.annotation;

import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.AnnotationTest;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by zhu8fei on 2017/5/7.
 */
@MarkTestTarget(AnnotationTest.class)
public class DataSetAnnotationUtilsJunitTest extends BaseJunitTest {

    @DataSet(path = "/", value = "SimpleFileReader", run = false)
    @Test
    public void dataSetFileName() throws Exception {
        Method method = getClass().getMethod("dataSetFileName");
        String fileName = DataSetAnnotationUtils.dataSetFileName(method);
        logger.info(fileName);
    }

    @DataSet(value = "SimpleFileReader", run = false)
    @Test
    public void dataSetFileNameToDot() throws Exception {
        Method method = getClass().getMethod("dataSetFileNameToDot");
        String fileName = DataSetAnnotationUtils.dataSetFileName(method);
        logger.info(fileName);
        Assert.assertTrue(fileName.contains("com/zhu8fei/framework/test/commons/annotation/DataSetAnnotationUtilsJunitTest.dataSetFileNameToDot.json"));
    }
}