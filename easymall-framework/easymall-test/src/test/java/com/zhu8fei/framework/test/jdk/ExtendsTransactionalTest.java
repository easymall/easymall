package com.zhu8fei.framework.test.jdk;

import com.zhu8fei.framework.test.commons.TransactionalBaseTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhu8fei on 2017/5/4.
 */
@MarkTestTarget(MethodTest.class)
public class ExtendsTransactionalTest extends TransactionalBaseTest {
    Logger logger = LoggerFactory.getLogger(ExtendsTransactionalTest.class);

    @Test
    public void override() {
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
        SubClass sc = new SubClass();
        logger.info(sc.getTableName());
    }

}

class SuperClass {
    Logger logger = LoggerFactory.getLogger(SuperClass.class);
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected String getTableName() {
        String className =this.getClass().getSimpleName();
        logger.info(className);
        return className;
    }
}

class SubClass extends SuperClass {

}
