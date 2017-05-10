package com.zhu8fei.framework.test.commons.mybatis;

import com.alibaba.fastjson.JSON;
import com.zhu8fei.framework.core.exception.EasyMallCoreException;
import com.zhu8fei.framework.core.lang.SimpleFileReader;
import com.zhu8fei.framework.test.commons.annotation.DataSetAnnotationUtils;
import com.zhu8fei.framework.test.commons.exception.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataSetBean;
import com.zhu8fei.framework.test.commons.mybatis.bean.SimpleTable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

/**
 * json文件处理实现
 * Created by zhu8fei on 2017/5/6.
 */
@Service
public class SimpleJsonFileProcessorIpml extends SimpleAbstractProcessor implements MybatisTestProcessor {
    @Override
    public void insertPrepareData(Method method) throws EasyMallTestException {
        boolean isLog = DataSetAnnotationUtils.isLog(method);
        String path = DataSetAnnotationUtils.dataSetFileName(method);
        try {
            String context = SimpleFileReader.readAnFileContext(path);
            if (isLog) {
                logger.debug("Json file context : {}", context);
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

        } catch (EasyMallCoreException e) {
            logger.error(e.getMessage(), e);
            throw new EasyMallTestException(e.getMessage(), e);
        }

    }

    @Override
    public boolean compareResult(Method method) throws EasyMallTestException {
        boolean isLog = DataSetAnnotationUtils.isLog(method);

        String path = DataSetAnnotationUtils.dataSetFileName(method);
        // 读取数据
        DataSetBean bean;
        try {
            String context = SimpleFileReader.readAnFileContext(path);
            if (isLog) {
                logger.debug("Json context : {}", context);
            }
            bean = JSON.parseObject(context, DataSetBean.class);

            // 判断数据是否匹配.
            if (isLog) {
                logger.debug("DataJsonBean format result : {}", bean);
            }
        } catch (EasyMallCoreException e) {
            logger.error(e.getMessage(), e);
            throw new EasyMallTestException(e.getMessage(), e);
        }

        // 处理结果并返回
        return expectData(bean);
    }

}
