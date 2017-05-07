package com.zhu8fei.framework.test.commons.annotation;

import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

/**
 * DataSet注解工具类
 * Created by zhu8fei on 2017/5/7.
 */
public class DataUtils {
    private static final String DOT = ".";
    private static final String DEFALT_NAME = "data";
    private static final String DEFALT_TYPE = "json";

    /**
     * 返回预处理数据文件路径
     *
     * @param method
     * @return
     * @throws
     */
    public static String dataSetFileName(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }
        DataSet dataSet = method.getAnnotation(DataSet.class);
        String path = dataSet.path();
        String file = dataSet.value();
        String type = dataSet.type();

        return getPath(method, path, file, type);
    }

    /**
     * 返回路径
     *
     * @param method
     * @param path
     * @param file
     * @param type
     * @return
     * @throws EasyMallTestException
     */
    private static String getPath(Method method, String path, String file, String type) throws EasyMallTestException {
        if (StringUtils.isEmpty(path)) {
            path = DOT;
        }
        if (StringUtils.isEmpty(file)) {
            file = DEFALT_NAME;
        }
        if (StringUtils.isEmpty(type)) {
            type = DEFALT_TYPE;
        }
        if(DOT.equals(path)){
            Class clz = method.getDeclaringClass();
            path = clz.getResource(".").getPath();
        }

        return null;
    }
}
