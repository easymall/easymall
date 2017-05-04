package com.zhu8fei.application.backend.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 主启动类
 * Created by zhu8fei on 2017/4/
 */
@SpringBootApplication
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        MDC.put("Trace", "      MAIN-THREAD");
        logger.info("main class start");
        SpringApplication.run(Main.class);
        MDC.clear();
    }
}
