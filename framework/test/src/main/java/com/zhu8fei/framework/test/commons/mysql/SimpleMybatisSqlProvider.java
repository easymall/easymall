package com.zhu8fei.framework.test.commons.mysql;

import com.zhu8fei.framework.test.commons.excel.CommonTestException;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhu8fei on 2017/5/6.
 */
public class SimpleMybatisSqlProvider {
    public String insert(SimpleTable simpleTable) {
        SQL sql = new SQL();
        sql.INSERT_INTO(simpleTable.getTableName());
        List<Map<String, String>> rows = simpleTable.getRows();
        if (rows.size() == 0) {
            throw new CommonTestException("预处理sql文件,数据为空值.");
        }
        for (Map<String, String> row : rows) {
            Set<String> keys = row.keySet();
            for (String key : keys) {
                sql.VALUES(key, "#{" + key + "}");
            }
        }

        //sql.VALUES("name", "#{name,jdbcType=VARCHAR}");

        return sql.toString();
    }

    public String select(SimpleTable simpleTable) {
        SQL sql = new SQL();
        sql.FROM(simpleTable.getTableName());
        List<Map<String, String>> rows = simpleTable.getRows();
        if (rows.size() == 0) {
            throw new CommonTestException("预处理sql文件,数据为空值.");
        }
        for (Map<String, String> row : rows) {
            Set<String> keys = row.keySet();
            sql.SELECT(keys.toArray(new String[]{}));
        }
        return sql.toString();
    }
}
