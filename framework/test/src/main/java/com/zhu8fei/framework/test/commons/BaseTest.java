package com.zhu8fei.framework.test.commons;


import com.zhu8fei.framework.test.commons.spring.bean.EmptyConfig;
import com.zhu8fei.framework.test.commons.spring.listener.DbUnitListener;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Created by zhu8fei on 2017/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmptyConfig.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class,
        DbUnitListener.class})
@MarkTestTarget({"MarkTestTarget"})
public class BaseTest {
    @Before
    public void setup() {

    }

    @After
    public void destroy() {

    }

}
