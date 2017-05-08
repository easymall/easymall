package com.zhu8fei.framework.test.commons.mybatis;

import java.util.List;

/**
 * Created by zhu8fei on 2017/5/8.
 */
public class DataJsonBean {
    private List<PrepareBean> prepare;
    private List<ExpectBean> expect;

    public List<PrepareBean> getPrepare() {
        return prepare;
    }

    public void setPrepare(List<PrepareBean> prepare) {
        this.prepare = prepare;
    }

    public List<ExpectBean> getExpect() {
        return expect;
    }

    public void setExpect(List<ExpectBean> expect) {
        this.expect = expect;
    }

    @Override
    public String toString() {
        return "DataJsonBean{" +
                "prepare=" + prepare +
                ", expect=" + expect +
                '}';
    }
}
