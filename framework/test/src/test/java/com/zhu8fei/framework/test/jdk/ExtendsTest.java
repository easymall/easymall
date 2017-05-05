package com.zhu8fei.framework.test.jdk;

import com.zhu8fei.framework.test.commons.BaseTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhu8fei on 2017/5/4.
 */
@MarkTestTarget
public class ExtendsTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(ExtendsTest.class);

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
