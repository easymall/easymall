package com.zhu8fei.framework.test.commons;

import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 需要spring依赖的测试
 * <p>
 * 注意. 此方法无事务控制.默认会提交到数据库.
 * <p>
 * Created by zhu8fei on 2017/5/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("easymall-test")
@MarkTestTarget(MarkTestTarget.class)
public class BaseSpringBootTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    protected MockMvc mvc;

    @Before
    public void setup() {

    }

    @After
    public void destroy() {

    }
}
