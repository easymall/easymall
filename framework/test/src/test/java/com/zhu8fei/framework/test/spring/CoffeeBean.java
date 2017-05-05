package com.zhu8fei.framework.test.spring;

import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by zhu8fei on 2017/5/6.
 */
@Service
@MarkTestTarget({"MarkTestTarget"})
public class CoffeeBean implements Serializable {
    Logger logger = LoggerFactory.getLogger(getClass());

    public void print() {
        logger.info("print");
    }
}
