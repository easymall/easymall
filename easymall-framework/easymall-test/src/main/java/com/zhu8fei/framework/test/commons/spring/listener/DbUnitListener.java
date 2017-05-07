package com.zhu8fei.framework.test.commons.spring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import java.util.UUID;

/**
 * Created by zhu8fei on 2017/5/5.
 */
public class DbUnitListener implements TestExecutionListener {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        logger.info("beforeTestClass");
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        MDC.put("Trace", UUID.randomUUID().toString());
        logger.info("prepareTestInstance");
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        logger.info("beforeTestMethod");
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        logger.info("afterTestMethod");
        MDC.clear();
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        logger.info("afterTestClass");
    }
}
