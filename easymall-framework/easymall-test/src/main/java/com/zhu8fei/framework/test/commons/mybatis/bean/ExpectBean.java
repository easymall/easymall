package com.zhu8fei.framework.test.commons.mybatis.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/8.
 */
public class ExpectBean {
    private String tableName;
    private List<String> columns;
    private List<List<String>> rows;
    private Map<String, Object> param;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "ExpectBean{" +
                "tableName='" + tableName + '\'' +
                ", columns=" + columns +
                ", rows=" + rows +
                ", param=" + param +
                '}';
    }
}
