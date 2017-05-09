package com.zhu8fei.framework.test.commons.mybatis.mapper;

import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.SimpleTable;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhu8fei on 2017/5/6.
 */
public class SimpleMybatisSqlProvider {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public String insert(SimpleTable simpleTable) throws EasyMallTestException {
        SQL sql = new SQL();
        sql.INSERT_INTO(simpleTable.getTableName());
        List<Map<String, Object>> rows = simpleTable.getRows();
        if (rows.size() == 0) {
            logger.error("预处理sql文件,数据为空值.");
            throw new EasyMallTestException("预处理sql文件,数据为空值.");
        }
        for (String column : simpleTable.getColumns()) {
            sql.INTO_COLUMNS(column);
        }

        StringBuilder sb = new StringBuilder(sql.toString());
        for (Map<String, Object> row : rows) {
            logger.debug(row.toString());
            sb.append("(");
            for (String column : simpleTable.getColumns()) {
                sb.append(" #{simpleTable.rows[{0}].").append(column).append("},");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(" ) ,");
        }
        sb.deleteCharAt(sb.length() - 1);
        logger.debug(sb.toString());
        return sb.toString();
    }

    public String select(SimpleTable simpleTable) throws EasyMallTestException {

        SQL sql = new SQL() {{
            SELECT(simpleTable.getColumns().toArray(new String[]{}));
            FROM(simpleTable.getTableName());
            Map<String, Object> params = simpleTable.getParam();
            Set<String> keys = params.keySet();

            for (String key : keys) {
                Object param = params.get(key);
                if (param instanceof Object[]) {
                    StringBuilder inSql = new StringBuilder(key);
                    inSql.append(" in (");
                    Object[] paramArr = (Object[]) param;

                    for (Object obj : paramArr) {
                        logger.info(obj.toString());
                        inSql.append("#{simpleTable.param[{0}].")
                                .append(key).append("[{0}]} ,");
                    }
                    inSql.deleteCharAt(inSql.length() - 1);
                    inSql.append(" ) ");

                    WHERE(inSql.toString());
                } else if (param instanceof String && ((String) param).contains("%")) {
                    WHERE(key + " like #{simpleTable.param[{0}]." + key + "}");
                } else {

                    WHERE(key + "=#{simpleTable.param[{0}]." + key + "}");
                }
            }

        }};
        logger.debug(sql.toString());
        return sql.toString();
    }
}
