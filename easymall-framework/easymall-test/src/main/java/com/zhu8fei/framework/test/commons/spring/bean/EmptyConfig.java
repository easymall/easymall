package com.zhu8fei.framework.test.commons.spring.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 空配置,扫描easy mall全部代码.
 * Created by zhu8fei on 2017/5/6.
 */
@Configuration
@ComponentScan(basePackages="com.zhu8fei")
public class EmptyConfig {
}
