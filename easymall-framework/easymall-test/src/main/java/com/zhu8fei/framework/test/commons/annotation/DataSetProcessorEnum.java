package com.zhu8fei.framework.test.commons.annotation;

import com.zhu8fei.framework.test.commons.mybatis.MybatisTestProcessor;
import com.zhu8fei.framework.test.commons.mybatis.SimpleJsonProcessorIpml;

/**
 * Created by cwx on 2017/5/10.
 */
public enum DataSetProcessorEnum {

    json(SimpleJsonProcessorIpml.class),;
    private Class<? extends MybatisTestProcessor> mybatisTestProcessor;

    DataSetProcessorEnum(Class<? extends MybatisTestProcessor> mybatisTestProcessor) {
        this.mybatisTestProcessor = mybatisTestProcessor;
    }

    public static Class<? extends MybatisTestProcessor> getProcessorType(String type) {
        for (DataSetProcessorEnum e : values()) {
            if (e.toString().equals(type)) {
                return e.mybatisTestProcessor;
            }
        }
        return null;
    }
}
