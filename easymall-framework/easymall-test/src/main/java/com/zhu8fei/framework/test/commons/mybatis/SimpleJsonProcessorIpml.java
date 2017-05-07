package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by zhu8fei on 2017/5/6.
 */
@Service
public class SimpleJsonProcessorIpml implements MybatisTestProcessor {
    @Override
    public void dataInsert(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }


    }

    @Override
    public DataCompareResult compareResult(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }

        return null;
    }

}
