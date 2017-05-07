package com.zhu8fei.framework.test.commons.annotation;

/**
 * 预处理数据.提供测试开始时的数据
 * Created by zhu8fei on 2017/5/7.
 */
public @interface DataSet {
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
    String value() default "data";

    /**
     * 文件类型
     *
     * @return
     */
    String type() default "json";
}
