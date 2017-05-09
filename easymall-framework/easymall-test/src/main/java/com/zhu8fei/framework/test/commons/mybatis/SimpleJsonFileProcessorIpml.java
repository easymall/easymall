package com.zhu8fei.framework.test.commons.mybatis;

import com.alibaba.fastjson.JSON;
import com.zhu8fei.framework.core.exception.EasyMallCoreException;
import com.zhu8fei.framework.core.lang.SimpleFileReader;
import com.zhu8fei.framework.test.commons.annotation.DataSetAnnotationUtils;
import com.zhu8fei.framework.test.commons.exception.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataCompareResult;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataJsonBean;
import com.zhu8fei.framework.test.commons.mybatis.bean.PrepareBean;
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
        String context;
        try {
            context = SimpleFileReader.readAnFileContext(path);
            if (isLog) {
                logger.debug("Json file context : {}", context);
            }
            DataJsonBean bean = JSON.parseObject(context, DataJsonBean.class);
            if (isLog) {
                logger.debug("DataJsonBean format result : {}", bean);
            }
            List<PrepareBean> prepares = bean.getPrepare();
            if (isLog) {
                logger.debug("批量插入预处理数据.");
            }
            List<SimpleTable> result = insert(prepares);
            if (isLog) {
                printPrepare(result);
            }

        } catch (EasyMallCoreException e) {
            logger.error(e.getMessage(), e);
            throw new EasyMallTestException(e.getMessage(), e);
        }

    }

    @Override
    public DataCompareResult compareResult(Method method) throws EasyMallTestException {


        return null;
    }

}
