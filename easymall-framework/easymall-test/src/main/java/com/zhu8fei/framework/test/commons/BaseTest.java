package com.zhu8fei.framework.test.commons;

import com.zhu8fei.framework.test.commons.spring.bean.EmptyConfig;
import com.zhu8fei.framework.test.commons.spring.listener.DbUnitListener;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Created by zhu8fei on 2017/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmptyConfig.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        DbUnitListener.class})
public class BaseTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setup() {

    }

    @After
    public void destroy() {

    }
}
