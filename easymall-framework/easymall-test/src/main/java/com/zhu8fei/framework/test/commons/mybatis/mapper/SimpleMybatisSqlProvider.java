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
            SELECT(" @rownum := ifnull(@rownum, 0) + 1 rownum ");
            FROM(simpleTable.getTableName());
            Map<String, Object> params = simpleTable.getParam();
            Set<String> keys = params.keySet();

            for (String key : keys) {
                Object param = params.get(key);
                if (param instanceof Object[]) {
                    StringBuilder inSql = new StringBuilder(key);
                    inSql.append(" in (");
                    Object[] paramArr = (Object[]) param;
                    int i = 0;
                    for (Object obj : paramArr) {
                        logger.info(obj.toString());
                        inSql.append("#{param[{" + i + "}].").append(key).append("[{" + i + "}]} ,");
                    }
                    inSql.deleteCharAt(inSql.length() - 1);
                    inSql.append(" ) ");
                    WHERE(inSql.toString());
                } else if (param instanceof String && ((String) param).contains("%")) {
                    WHERE(key + " like #{param[{0}]." + key + "}");
                } else {
                    WHERE(key + "=#{param[{0}]." + key + "}");
                }
            }

        }};
        logger.debug(sql.toString());
        return sql.toString();
    }
}
