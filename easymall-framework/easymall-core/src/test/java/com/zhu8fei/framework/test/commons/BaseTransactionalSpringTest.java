package com.zhu8fei.framework.test.commons;

import com.zhu8fei.framework.core.jdbc.DataResourceConfig;
import com.zhu8fei.framework.core.mybatis.config.MybatisConfig;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * 带事务操作的测试基类
 * Created by zhu8fei on 2017/5/4.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {

        MybatisConfig.class, DataResourceConfig.class

})
@ComponentScan(basePackages = "com.zhu8fei")
@Transactional
@Rollback
@ActiveProfiles("easymall-test")
@MarkTestTarget({MarkTestTarget.class})
public class BaseTransactionalSpringTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setup() {

    }

    @After
    public void destroy() {

    }

}
