package com.zhu8fei.framework.test.commons;


import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一般测试不需要配置spring上下文时使用
 * Created by zhu8fei on 2017/5/7.
 */
@RunWith(JUnit4.class)
@MarkTestTarget(MarkTestTarget.class)
public class BaseJunitTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setup() {

    }

    @After
    public void destroy() {

    }
}
