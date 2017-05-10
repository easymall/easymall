package com.zhu8fei.framework.core.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@RestController
public class SystemCaseService {
    private Logger logger = LoggerFactory.getLogger(SystemCaseService.class);

    @RequestMapping("/")
    public String service() {
        logger.info("test service");
        return "hello";
    }

}
