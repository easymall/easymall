package com.zhu8fei.framework.test.commons.mybatis.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class SimpleTable {
    private Long id;
    private String tableName;
    private Map<String, Object> row = new HashMap<>();
    private List<String> columns = new ArrayList<>();
    private Map<String, Object> param = new HashMap<>();

    public Object put(String column, String value) {
        return row.put(column, value);
    }

    public void putRowAll(Map<String, Object> row) {
        this.row.putAll(row);
    }

    public Map<String, Object> getRow() {
        return row;
    }

    public void addColumn(String column) {
        columns.add(column);
    }

    public void addAllColumns(List<String> columns) {
        this.columns.addAll(columns);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
