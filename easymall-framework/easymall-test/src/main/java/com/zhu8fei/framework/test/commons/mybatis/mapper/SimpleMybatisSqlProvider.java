package com.zhu8fei.framework.test.commons.mybatis.mapper;

import com.zhu8fei.framework.test.commons.exception.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.bean.SimpleTable;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by zhu8fei on 2017/5/6.
 */
public class SimpleMybatisSqlProvider {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public String insert(SimpleTable simpleTable) throws EasyMallTestException {
        SQL sql = new SQL() {{
            INSERT_INTO(simpleTable.getTableName());
            for (String column : simpleTable.getColumns()) {
                INTO_VALUES("#{row." + column + "}");
                INTO_COLUMNS(column);
            }
        }};
        logger.debug(sql.toString());
        return sql.toString();
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
                    for (int i = 0; i < paramArr.length; i++) {
                        inSql.append("#{param.").append(key).append("[" + i + "]} ,");
                    }
                    inSql.deleteCharAt(inSql.length() - 1);
                    inSql.append(" ) ");
                    WHERE(inSql.toString());
                } else if (param instanceof String && ((String) param).contains("%")) {
                    WHERE(key + " like '" + param + "'");
                } else {
                    WHERE(key + "=#{param." + key + "}");
                }
            }

        }};
        logger.debug(sql.toString());
        return sql.toString();
    }
}
