package com.zhu8fei.framework.test.commons.mybatis.mapper;

import com.zhu8fei.framework.test.commons.mybatis.bean.SimpleTable;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/6.
 */
@Repository
public interface SimpleMybatisMapper {
    @InsertProvider(type = SimpleMybatisSqlProvider.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(SimpleTable simpleTable);

    @SelectProvider(type = SimpleMybatisSqlProvider.class, method = "select")
    List<Map<String, String>> select(SimpleTable simpleTable);

}
