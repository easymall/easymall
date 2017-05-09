package com.zhu8fei.framework.test.commons.mybatis;

import com.alibaba.fastjson.JSON;
import com.zhu8fei.framework.test.commons.annotation.DataSetAnnotationUtils;
import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataCompareResult;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataJsonBean;
import com.zhu8fei.framework.test.commons.mybatis.bean.PrepareBean;
import com.zhu8fei.framework.test.commons.mybatis.bean.SimpleTable;
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
    }

    @Override
    public DataCompareResult compareResult(Method method) throws EasyMallTestException {
        // 读取数据

        // 判断数据是否匹配.

        // 处理结果并返回
        DataCompareResult result = new DataCompareResult();
        return result;
    }

}
