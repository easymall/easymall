package com.zhu8fei.framework.test.commons.mybatis.config;

import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * Created by zhu8fei on 2017/5/4.
 */
@Configuration
public class MybatisConfig implements TransactionManagementConfigurer {
    private Logger logger = LoggerFactory.getLogger(MybatisConfig.class);
    @Autowired
    DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws EasyMallTestException{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.zhu8fei.**.mybatis.model");

        //分页插件
        // PageInterceptor pageHelper = new PageInterceptor();
        //FIXME 配置没有修改并不是同一个page插件, 通用字段插件没有引入
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
        //添加插件
        bean.setPlugins(new Interceptor[]{});
        try {
            return bean.getObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new EasyMallTestException(e);
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
