package com.zhu8fei.framework.test.commons.mybatis;

import com.alibaba.fastjson.JSON;
import com.zhu8fei.framework.test.commons.mybatis.bean.DataSetBean;
import org.springframework.stereotype.Service;

/**
 * 注解上直接json处理实现
 * Created by zhu8fei on 2017/5/6.
 */
@Service
public class SimpleJsonProcessorIpml extends SimpleAbstractProcessor implements MybatisTestProcessor {
    protected DataSetBean getDataSetPrepareBean(String context) {
        DataSetBean bean = JSON.parseObject(context, DataSetBean.class);
        return bean;
    }

    protected DataSetBean getDataSetCompareBean(String context) {
        DataSetBean bean = JSON.parseObject(context, DataSetBean.class);
        return bean;
    }

}
