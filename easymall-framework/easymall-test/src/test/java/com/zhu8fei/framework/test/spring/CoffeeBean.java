package com.zhu8fei.framework.test.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by zhu8fei on 2017/5/6.
 */
@Repository
public class CoffeeBean implements Serializable {
    Logger logger = LoggerFactory.getLogger(getClass());

    public void print() {
        logger.info("print");
    }
}
