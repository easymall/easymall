package com.zhu8fei.framework.core.mybatis.config;


import com.zhu8fei.framework.core.exception.EasyMallCoreException;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * Created by zhu8fei on 2017/5/4.
 */
@ComponentScan(basePackages="com.zhu8fei")
@Configuration
@Profile("easymall-test")
public class MybatisConfig implements TransactionManagementConfigurer {
    private Logger logger = LoggerFactory.getLogger(MybatisConfig.class);
    @Autowired
    DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws EasyMallCoreException{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.zhu8fei.**.mybatis.model");

        //添加插件
        bean.setPlugins(new Interceptor[]{});
        try {
            return bean.getObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new EasyMallCoreException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }


}
