package com.zhu8fei.framework.test.spring;

import com.zhu8fei.framework.test.commons.TransactionalBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhu8fei on 2017/5/5.
 */
public class SpringJunitProcessTestTransactional extends TransactionalBaseTest {
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



