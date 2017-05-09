package com.zhu8fei.framework.common.mybatis;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by zhu8fei on 2017/5/6.
 */
public class DataResourceConfig {
    // FIXME  多环境配置数据源时可以使用profile区分.  但此处还没有测试.
    @Profile("default")
    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&aut");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setInitialSize(3);
        dataSource.setMinIdle(3);
        dataSource.setMaxIdle(5);
        dataSource.setMaxTotal(10);
        return dataSource;
    }


}
