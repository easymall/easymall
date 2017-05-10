package com.zhu8fei.framework.test.commons.mybatis;

import com.alibaba.fastjson.JSON;
import com.zhu8fei.framework.test.commons.annotation.DataSetAnnotationUtils;
import com.zhu8fei.framework.test.commons.exception.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.bean.*;
import com.zhu8fei.framework.test.commons.mybatis.mapper.SimpleMybatisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 注解上直接json处理实现
 * Created by zhu8fei on 2017/5/6.
 */
@Service
public class SimpleJsonProcessorIpml extends SimpleAbstractProcessor implements MybatisTestProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource(name = "simpleMybatisMapper")
    private SimpleMybatisMapper simpleMybatisMapper;

    @Override
    public void insertPrepareData(Method method) throws EasyMallTestException {
        boolean isLog = DataSetAnnotationUtils.isLog(method);
        String context = DataSetAnnotationUtils.dataContext(method);
        if (isLog) {
            logger.debug("Json context : {}", context);
        }
        DataSetBean bean = JSON.parseObject(context, DataSetBean.class);
        if (isLog) {
            logger.debug("DataJsonBean format result : {}", bean);
        }
        if (isLog) {
            logger.debug("批量插入预处理数据.");
        }
        List<SimpleTable> result = insert(bean);
        if (isLog) {
            printPrepare(result);
        }
    }

    @Override
    public boolean compareResult(Method method) throws EasyMallTestException {
        boolean isLog = DataSetAnnotationUtils.isLog(method);
        // 读取数据
        String context = DataSetAnnotationUtils.dataContext(method);
        if (isLog) {
            logger.debug("Json context : {}", context);
        }
        DataSetBean bean = JSON.parseObject(context, DataSetBean.class);

        // 判断数据是否匹配.
        if (isLog) {
            logger.debug("DataJsonBean format result : {}", bean);
        }

        // 处理结果并返回
        return expectData(bean);
    }



}
