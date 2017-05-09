package com.zhu8fei.framework.test.commons.mybatis.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据比对结束
 * Created by zhu8fei on 2017/5/7.
 */
public class DataCompareResult {
    public static final String index = "";
    private boolean success = true;
    private List<Map<String, Object>> diffRows;

    public DataCompareResult() {
        diffRows = new ArrayList<>();
    }

    public void addDiffRow(Map<String, Object> row) {
        diffRows.add(row);
    }

    public void addDiffAllRow(List<Map<String, Object>> rows) {
        diffRows.addAll(rows);
    }

    public List<Map<String, Object>> getDiffRows() {
        return diffRows;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
