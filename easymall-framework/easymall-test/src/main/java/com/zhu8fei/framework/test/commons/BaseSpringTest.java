package com.zhu8fei.framework.test.commons;

import com.zhu8fei.framework.test.commons.jdbc.DataResourceConfig;
import com.zhu8fei.framework.test.commons.mybatis.config.MybatisConfig;
import com.zhu8fei.framework.test.commons.spring.bean.EmptyConfig;
import com.zhu8fei.framework.test.commons.spring.listener.JunitCaseListener;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
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
 * 需要spring依赖的测试
 *
 * 注意. 此方法无事务控制.默认会提交到数据库.
 *
 * Created by zhu8fei on 2017/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {

        MybatisConfig.class, DataResourceConfig.class, EmptyConfig.class

})
@TestExecutionListeners(listeners = {

        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        JunitCaseListener.class

})
@MarkTestTarget(MarkTestTarget.class)
public class BaseSpringTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setup() {

    }

    @After
    public void destroy() {

    }
}
