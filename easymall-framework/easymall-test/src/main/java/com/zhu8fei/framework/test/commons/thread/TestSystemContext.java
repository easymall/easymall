package com.zhu8fei.framework.test.commons.thread;

import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/9.
 */
public class TestSystemContext {
    private static transient ThreadLocal<Map<String, String>> contextMap = new ThreadLocal();

}
