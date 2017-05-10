package com.zhu8fei.framework.test.commons.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 预处理数据.提供测试开始时的数据
 * prepare 准备数据
 * expect 预期数据
 * Created by zhu8fei on 2017/5/7.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSet {
    /**
     * {
     * "prepare":[{
     * "tableName":"prepare_table",
     * "columns":["column1","column2",...],
     * "rows":[["value1","value2",...],["value1","value2",...] , ... ]
     * },
     * ...
     * ],
     * "expect":[{
     * "tableName":"expect_table",
     * "columns":["column1","column2",...],
     * "rows":[["value1","value2",...],["value1","value2",...] , ... ],
     * "param":{"column":"value" , ...}
     * },
     * ...
     * ]
     * }
     */
    String value() default "";

    /**
     * 文件路径
     * value存在则不使用此字段
     */
    String path() default ".";

    /**
     * 文件名
     * value存在则不使用此字段
     */
    String file() default "";

    /**
     * 文件类型
     */
    String type() default "json";

    /**
     * 是否执行数据验证处理
     */
    boolean run() default true;

    /**
     * 是否打印日志
     */
    boolean log() default false;
}

