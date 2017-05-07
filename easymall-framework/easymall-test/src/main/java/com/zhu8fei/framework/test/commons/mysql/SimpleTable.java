package com.zhu8fei.framework.test.commons.mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class SimpleTable {
    private String tableName;
    private List<Map<String, String>> rows = new ArrayList<>();

    public List<Map<String, String>> getRows() {
        return rows;
    }
    public void addRows(Map<String,String> row){
        rows.add(row);
    }

    public void addAllRows(List<Map<String, String>> rows){
        this.rows.addAll(rows);
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
