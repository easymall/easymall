package com.zhu8fei.framework.core.mybatis.plugin;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by zhu8fei on 2017/3/28.
 */
public class CommonSqlPlugin implements Interceptor {
    private Logger logger = LoggerFactory.getLogger(CommonSqlPlugin.class);

    public Object intercept(Invocation invocation) throws Throwable {
        logger.debug("run mybatis plugin intercept");
        Object ojb = invocation.proceed();
        logger.debug("run mybatis plugin intercept end");
        logger.debug("intercept return {}", ojb.toString());
        return ojb;
    }

    public Object plugin(Object target) {
        logger.debug("run mybatis plugin method");
        Object obj = Plugin.wrap(target, this);
        logger.debug("run mybatis plugin method end");
        logger.debug(" plugin method return {}", obj.toString());
        return obj;
    }

    public void setProperties(Properties properties) {
        logger.debug("run mybatis plugin setProperties");
        logger.debug(properties.toString());
    }
}
