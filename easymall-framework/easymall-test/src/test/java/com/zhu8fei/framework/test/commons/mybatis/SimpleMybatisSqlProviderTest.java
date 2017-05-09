package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.BaseTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/8.
 */
@Ignore // 暂时忽略这个测试
@MarkTestTarget
public class SimpleMybatisSqlProviderTest extends BaseTest {
    private SimpleMybatisSqlProvider simpleMybatisSqlProvider;

    @Override
    public void setup() {
        super.setup();
        simpleMybatisSqlProvider = new SimpleMybatisSqlProvider();
    }

    @Test
    public void insert() throws Exception {
        SimpleTable simpleTable = new SimpleTable();
        simpleTable.setTableName("u_user");
        simpleTable.addColumn("id");
        simpleTable.addColumn("name");
        Map<String, Object> row = new HashMap<>();
        row.put("id", "1");
        row.put("name", "name");
        simpleTable.addRow(row);
        row = new HashMap<>();
        row.put("id", "2");
        row.put("name", "test");
        simpleTable.addRow(row);
        String sql = simpleMybatisSqlProvider.insert(simpleTable);

        logger.info(sql);
    }

    @Test
    public void select() throws Exception {
        SimpleTable simpleTable = new SimpleTable();
        simpleTable.setTableName("u_user");
        simpleTable.addColumn("id");
        simpleTable.addColumn("name");
        simpleTable.putParam("name", new String[]{"aaa", "BBB"});
        simpleTable.putParam("password", "abc%");
        simpleTable.putParam("id", "bbb");
        String sql = simpleMybatisSqlProvider.select(simpleTable);
        logger.info(sql);
    }

}