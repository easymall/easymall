package com.zhu8fei.framework.test.commons;

import org.junit.After;
import org.junit.Before;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * Created by cwx on 2017/5/4.
 */
public class BaseTest {
    @Before
    public void setup(){
        MDC.put("Trace", UUID.randomUUID().toString());
    }
    @After
    public void destroy(){
        MDC.clear();
    }

}
