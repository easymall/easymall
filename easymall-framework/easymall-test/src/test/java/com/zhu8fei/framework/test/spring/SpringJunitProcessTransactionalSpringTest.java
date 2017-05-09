package com.zhu8fei.framework.test.spring;

import com.zhu8fei.framework.test.commons.BaseSpringTest;
import com.zhu8fei.framework.test.commons.spring.bean.EmptyConfig;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by zhu8fei on 2017/5/5.
 */
@ContextConfiguration(classes = {EmptyConfig.class})
@MarkTestTarget(MethodTest.class)
public class SpringJunitProcessTransactionalSpringTest extends BaseSpringTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CoffeeBean coffeeBean;

    @Test
    public void test1() {
        coffeeBean.print();
        logger.info("ok1");
    }

    @Test
    public void test2() {
        logger.info("ok2");
    }

}



