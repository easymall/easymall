package com.zhu8fei.framework.test.jdk;

import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by zhu8fei on 2017/5/7.
 */
@MarkTestTarget(MarkTestTarget.class)
public class MethodAndClass {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void methodReturnClass() throws NoSuchMethodException {
        Method method = MethodAndClass.class.getMethod("methodReturnClass");
        logger.info(method.getDeclaringClass().getName());
    }
}
