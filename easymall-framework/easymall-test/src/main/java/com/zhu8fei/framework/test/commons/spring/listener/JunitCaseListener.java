package com.zhu8fei.framework.test.commons.spring.listener;

import com.zhu8fei.framework.test.commons.annotation.DataSet;
import com.zhu8fei.framework.test.commons.annotation.DataSetAnnotationUtils;
import com.zhu8fei.framework.test.commons.mybatis.MybatisTestProcessor;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * 使用DataSet注解 预处理数据 , 对比操作结果
 *
 * @see DataSet
 * Created by zhu8fei on 2017/5/5.
 */
@Transactional
public class JunitCaseListener extends AbstractTestExecutionListener implements TestExecutionListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Returns {@code 2500}.
     */
    @Override
    public final int getOrder() {
        return 2500;
    }

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        logger.debug("beforeTestClass");
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        MDC.put("Trace", UUID.randomUUID().toString());
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        Method method = testContext.getTestMethod();
        if (DataSetAnnotationUtils.isRun(method)) {
            MybatisTestProcessor mybatisTestProcessor = testContext.
                    getApplicationContext().getBean(DataSetAnnotationUtils.getImplName(method));
            mybatisTestProcessor.insertPrepareData(method);
        }
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        Method method = testContext.getTestMethod();
        if (DataSetAnnotationUtils.isRun(method)) {
            MybatisTestProcessor mybatisTestProcessor = testContext.
                    getApplicationContext().getBean(DataSetAnnotationUtils.getImplName(method));
            boolean success = mybatisTestProcessor.compareResult(method);
            if (!success) {
                logger.info("Data test result : failure");
                Assert.fail();
            }
        }
        logger.info("Data test result : success");
        MDC.clear();
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {

    }

}
