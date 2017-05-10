package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.exception.EasyMallTestException;

import java.lang.reflect.Method;

/**
 * 提供测试所需的预处理数据及数据结果比对接口
 * 需要额外的数据类型及方式时,可以实现此接口
 *
 * @See SimpleJsonProcessorIpml
 * Created by zhu8fei on 2017/5/7.
 */
public interface MybatisTestProcessor {
    /**
     * 通过给定的测试方法获取其注解. 获取测试源数据文件. 并插入数据.
     *
     * @param method
     */
    void insertPrepareData(Method method) throws EasyMallTestException;

    /**
     * 通过给定的测试方法获取其注解. 获取测试结果数据文件. 并进行比对.
     *
     * @param method
     * @return 比对结果
     */
    boolean compareResult(Method method) throws EasyMallTestException;
}
