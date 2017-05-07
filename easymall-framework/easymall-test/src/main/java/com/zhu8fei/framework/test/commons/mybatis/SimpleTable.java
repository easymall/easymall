package com.zhu8fei.framework.test.commons.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class SimpleTable {
    private String tableName;
    private List<Map<String, Object>> rows = new ArrayList<>();

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void addRows(Map<String, Object> row) {
        rows.add(row);
    }

    public void addAllRows(List<Map<String, Object>> rows) {
        this.rows.addAll(rows);
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
