package com.zhu8fei.framework.test.commons.annotation;

import com.zhu8fei.framework.test.commons.exception.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.MybatisTestProcessor;
import com.zhu8fei.framework.test.commons.mybatis.SimpleJsonFileProcessorIpml;
import com.zhu8fei.framework.test.commons.mybatis.SimpleJsonProcessorIpml;
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
     * @param method 测试方法
     * @return 是否运行
     */
    public static boolean isRun(Method method) {
        DataSet dataSet = method.getAnnotation(DataSet.class);
        return dataSet != null && dataSet.run();
    }

    /**
     * 是否运行
     *
     * @param method 测试方法
     * @return 实现类名
     * @throws EasyMallTestException
     */
    public static Class<? extends MybatisTestProcessor> getImplName(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }
        DataSet dataSet = method.getAnnotation(DataSet.class);

        // xxx 想不明白这个注册器要怎么写了.

        String type = dataSet.type();
        String value = dataSet.value();
        if("json".equals(type)){
            if(StringUtils.isEmpty(value)){
                return SimpleJsonFileProcessorIpml.class;
            }else{
                return SimpleJsonProcessorIpml.class;
            }
        }
        throw new EasyMallTestException("实现类型错误");
    }

    /**
     * 是否打印日志
     *
     * @param method 测试方法
     * @return 是否打印日志
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
     * 直接返回数据内容
     *
     * @param method 测试方法
     * @return 注解内容
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
     * @param method 测试方法
     * @return 文件内容
     * @throws EasyMallTestException
     */
    public static String dataSetFileName(Method method) throws EasyMallTestException {
        if (method == null) {
            throw new EasyMallTestException("Test method is not be null");
        }
        DataSet dataSet = method.getAnnotation(DataSet.class);
        String path = dataSet.path();
        String file = dataSet.file();
        String type = dataSet.type();
        if (StringUtils.isEmpty(file)) {
            file = method.getDeclaringClass().getSimpleName();
            file += "." + method.getName();
        }
        return getPath(method, path, file, type);
    }

    /**
     * 返回路径
     *
     * @param method 测试方法
     * @param path 文件地址(不包含文件名)
     * @param file 文件名
     * @param type 文件类型
     * @return 返回文件内容
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
