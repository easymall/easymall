package com.zhu8fei.framework.test.commons.mybatis.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class SimpleTable {
    private String tableName;
    private List<Map<String, Object>> rows = new ArrayList<>();
    private List<String> columns = new ArrayList<>();
    private Map<String, Object> param = new HashMap<>();

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void addRow(Map<String, Object> row) {
        rows.add(row);
    }

    public void addAllRows(List<Map<String, Object>> rows) {
        this.rows.addAll(rows);
    }

    public void addColumn(String column) {
        columns.add(column);
    }

    public void addAllColumns(List<String> columns) {
        columns.addAll(columns);
    }

    public List<String> getColumns() {
        return columns;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void putParam(String column, Object value) {
        param.put(column, value);
    }

    public Map<String, Object> getParam() {
        return param;
    }
}
