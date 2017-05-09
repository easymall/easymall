package com.zhu8fei.framework.test.commons.mybatis.mapper;

import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.bean.SimpleTable;
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
        sb.append(" values ");
        int i = 0 ;
        for (Map<String, Object> row : rows) {
            logger.debug(row.toString());
            sb.append("(");
            for (String column : simpleTable.getColumns()) {
                sb.append(" #{rows[" + i + "].").append(column).append("},");
            }
            i++;
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
