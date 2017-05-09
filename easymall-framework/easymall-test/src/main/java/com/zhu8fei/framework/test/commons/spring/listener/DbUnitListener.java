package com.zhu8fei.framework.test.commons.spring.listener;

import com.zhu8fei.framework.test.commons.annotation.DataSet;
import com.zhu8fei.framework.test.commons.mybatis.MybatisTestProcessor;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataCompareResult;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by zhu8fei on 2017/5/5.
 */
@Component
@Transactional
public class DbUnitListener implements TestExecutionListener, ApplicationContextAware {

    Logger logger = LoggerFactory.getLogger(getClass());
    private ApplicationContext applicationContext;

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        logger.debug("beforeTestClass");
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        MDC.put("Trace", UUID.randomUUID().toString());
        logger.debug("prepareTestInstance");
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        Method method = testContext.getTestMethod();
        DataSet dataSet = method.getAnnotation(DataSet.class);
        if (dataSet != null) {
            Class implClass = dataSet.impl();
            MybatisTestProcessor mybatisTestProcessor = applicationContext.<MybatisTestProcessor>getBean(implClass);
            mybatisTestProcessor.insertPrepareData(method);
        }
        logger.debug("beforeTestMethod");
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        logger.debug("afterTestMethod");
        MDC.clear();
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        Method method = testContext.getTestMethod();
        DataSet dataSet = method.getAnnotation(DataSet.class);
        if (dataSet != null) {
            Class implClass = dataSet.impl();
            MybatisTestProcessor mybatisTestProcessor = applicationContext.<MybatisTestProcessor>getBean(implClass);
            DataCompareResult dataCompareResult = mybatisTestProcessor.compareResult(method);
            if (dataCompareResult.isSuccess()) {
                logger.info("Data test result : success");
            } else {
                logger.info("Data test result : failure");
                Assert.fail();
            }

        }
        logger.debug("afterTestClass");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
