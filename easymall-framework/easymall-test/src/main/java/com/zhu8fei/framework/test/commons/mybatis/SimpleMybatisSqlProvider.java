package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhu8fei on 2017/5/6.
 */
public class SimpleMybatisSqlProvider {
    public String insert(SimpleTable simpleTable) throws EasyMallTestException {
        SQL sql = new SQL();
        sql.INSERT_INTO(simpleTable.getTableName());
        List<Map<String, Object>> rows = simpleTable.getRows();
        if (rows.size() == 0) {
            throw new EasyMallTestException("预处理sql文件,数据为空值.");
        }
        for (Map<String, Object> row : rows) {
            Set<String> keys = row.keySet();
            for (String key : keys) {
                sql.VALUES(key, "#{" + key + "}");
            }
        }

        //sql.VALUES("name", "#{name,jdbcType=VARCHAR}");

        return sql.toString();
    }

    public String select(SimpleTable simpleTable) throws EasyMallTestException {
        SQL sql = new SQL();
        sql.FROM(simpleTable.getTableName());
        List<Map<String, Object>> rows = simpleTable.getRows();
        if (rows.size() == 0) {
            throw new EasyMallTestException("预处理sql文件,数据为空值.");
        }
        for (Map<String, Object> row : rows) {
            Set<String> keys = row.keySet();
            sql.SELECT(keys.toArray(new String[]{}));
        }
        return sql.toString();
    }
}
