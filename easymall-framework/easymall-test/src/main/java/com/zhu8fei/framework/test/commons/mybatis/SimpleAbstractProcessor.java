package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.mybatis.bean.PrepareBean;
import com.zhu8fei.framework.test.commons.mybatis.bean.SimpleTable;
import com.zhu8fei.framework.test.commons.mybatis.mapper.SimpleMybatisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by zhu8fei on 2017/5/6.
 */
@Service
public class SimpleAbstractProcessor {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Resource(name = "simpleMybatisMapper")
    protected SimpleMybatisMapper simpleMybatisMapper;

    protected List<SimpleTable> insert(List<PrepareBean> prepares) {
        if(prepares == null){
            return new ArrayList<>();
        }
        List<SimpleTable> result = new ArrayList<>();
        for (PrepareBean prepare : prepares) {
            SimpleTable st = new SimpleTable();
            st.setTableName(prepare.getTableName());
            List<String> columns = prepare.getColumns();
            st.addAllColumns(columns);
            List<List<Object>> rows = prepare.getRows();
            // lambada 应该怎么写...
            for (List<Object> row : rows) {
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 0; i < columns.size(); i++) {
                    rowMap.put(columns.get(i), row.get(i));
                }
                st.addRow(rowMap);
            }
            simpleMybatisMapper.insert(st);
            result.add(st);
        }
        return result;
    }

    /**
     * 打印结果. 这个东西.是打还是不打好?
     * @param result 预处理数据插入结果
     */
    protected void printPrepare(List<SimpleTable> result) {
        if (result != null && result.size() != 0) {
            for (SimpleTable simpleTable : result) {
                logger.debug("Prepare table name : {}",simpleTable.getTableName());
                List<Map<String, Object>> rows = simpleTable.getRows();
                for (Map<String,Object> row:rows){
                    logger.debug("Prepare id : {}" ,row.get("id"));
                }
            }
       }
    }

}
