package com.zhu8fei.framework.test.commons.annotation;

import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

/**
 * DataSet注解工具类
 * Created by zhu8fei on 2017/5/7.
 */
public class DataSetAnnotationUtils {
    private static final String DOT = ".";
    private static final String DEFAULT_NAME = "data";
    private static final String DEFAULT_TYPE = "json";

    /**
     * 是否运行
     *
     * @param method
     * @return
     * @throws EasyMallTestException
     */
    public static boolean isRun(Method method) {
        DataSet dataSet = method.getAnnotation(DataSet.class);
        return dataSet != null && dataSet.run();
    }

    /**
     * 是否运行
     *
     * @param method
     * @return
     * @throws EasyMallTestException
     */
    public static Class getImplName(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }
        DataSet dataSet = method.getAnnotation(DataSet.class);
        return dataSet.impl();
    }

    /**
     * 是否打印日志
     *
     * @param method
     * @return
     * @throws EasyMallTestException
     */
    public static boolean isLog(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }
        DataSet dataSet = method.getAnnotation(DataSet.class);
        return dataSet.log();
    }

    /**
     * 返回主键名
     *
     * @param method
     * @return
     * @throws EasyMallTestException
     */
    public static String getDataKeyName(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }
        DataSet dataSet = method.getAnnotation(DataSet.class);
        String keyName = dataSet.key();
        return keyName;
    }

    /**
     * 直接返回数据内容
     *
     * @param method
     * @return
     * @throws EasyMallTestException
     */
    public static String dataContext(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }
        DataSet dataSet = method.getAnnotation(DataSet.class);
        String context = dataSet.value();
        return context;
    }

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
        String file = dataSet.file();
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
            file = DEFAULT_NAME;
        }
        if (StringUtils.isEmpty(type)) {
            type = DEFAULT_TYPE;
        }
        if (DOT.equals(path)) {
            Class clz = method.getDeclaringClass();
            path = clz.getResource(".").getFile();
        } else {
            path = DataSetAnnotationUtils.class.getResource("/").getFile() + path;
        }
        return path + file + DOT + type;
    }
}
