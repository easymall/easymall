package com.zhu8fei.backend.main;

import org.apache.log4j.NDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


/**
 * 主启动类
 * Created by zhu8fei on 2017/4/
 */
@EnableAutoConfiguration
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        NDC.push("      MAIN-THREAD");
        SpringApplication.main(args);
        NDC.clear();
    }
}
