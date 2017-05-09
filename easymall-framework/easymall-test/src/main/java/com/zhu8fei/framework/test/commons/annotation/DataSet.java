package com.zhu8fei.framework.test.commons.annotation;

import com.zhu8fei.framework.test.commons.mybatis.SimpleJsonProcessorIpml;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 预处理数据.提供测试开始时的数据
 * prepare 准备数据
 * expect 预期数据
 *
 *
 *
 * Created by zhu8fei on 2017/5/7.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSet {
    /**
     * {
     *     "prepare":[{
     *         "tableName":"prepare_table",
     *         "columns":["column1","column2",...],
     *         "rows":[["value1","value2",...],["value1","value2",...] , ... ]
     *         },
     *     ...
     *     ]
     *     "expect":[{
     *         "tableName":"expect_table",
     *         "columns":["column1","column2",...],
     *         "rows":[["value1","value2",...],["value1","value2",...] , ... ],
     *         "param":{"column":"value" , ...}
     *     },
     *     ...
     *     ]
     * }
     */
    String value() default "";

    /**
     * 文件路径
     *
     * @return
     */
    String path() default ".";

    /**
     * 文件名
     *
     * @return
     */
    String file() default "data";

    /**
     * 文件类型
     *
     * @return
     */
    String type() default "json";

    boolean run() default true;

    Class impl() default SimpleJsonProcessorIpml.class;

    boolean log() default  false;
}
