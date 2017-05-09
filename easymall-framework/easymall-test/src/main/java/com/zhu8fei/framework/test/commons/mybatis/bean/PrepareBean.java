package com.zhu8fei.framework.test.commons.mybatis.bean;

import java.util.List;

/**
 * Created by zhu8fei on 2017/5/8.
 */
public class PrepareBean {
    private String tableName;
    private List<String> columns;
    private List<List<Object>> rows;

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

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ExpectBean{" +
                "tableName='" + tableName + '\'' +
                ", columns=" + columns +
                ", rows=" + rows +
                '}';
    }
}
