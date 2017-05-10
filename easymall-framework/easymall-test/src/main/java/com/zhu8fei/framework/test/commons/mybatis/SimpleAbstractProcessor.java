package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.core.lang.CollectionDiff;
import com.zhu8fei.framework.test.commons.mybatis.bean.*;
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

    protected List<SimpleTable> insert(DataSetBean bean) {
        if (bean == null) {
            logger.warn("Not found prepare data !");
            return new ArrayList<>();
        }
        List<PrepareBean> prepares = bean.getPrepare();
        if (prepares == null) {
            logger.warn("Not found prepare data !");
            return new ArrayList<>();
        }
        List<SimpleTable> result = new ArrayList<>();
        for (PrepareBean prepare : prepares) {
            // 当前循环 一张表的数据
            // 获取当前表全部数据行
            List<List<Object>> rows = prepare.getRows();
            // 循环数据并插入
            for (List<Object> row : rows) {
                SimpleTable st = new SimpleTable();
                st.setTableName(prepare.getTableName());
                List<String> columns = prepare.getColumns();
                st.addAllColumns(columns);
                Map<String, Object> rowMap = new HashMap<>();
                // 拼装数据
                for (int i = 0; i < columns.size(); i++) {
                    rowMap.put(columns.get(i), row.get(i));
                }
                st.putRowAll(rowMap);
                simpleMybatisMapper.insert(st);
                result.add(st);
            }
        }
        return result;
    }

    /**
     * @param bean
     * @return
     */
    protected boolean expectData(DataSetBean bean) {
        if (bean == null) {
            logger.warn("Not found expect data !");
            return true;
        }
        List<ExpectBean> expectBeans = bean.getExpect();
        if (expectBeans == null) {
            logger.warn("Not found expect data !");
            return true;
        }

        for (int i = 0; i < expectBeans.size(); i++) {
            ExpectBean expectBean = expectBeans.get(i);
            SimpleTable st = new SimpleTable();
            st.putParamAll(expectBean.getParam());
            st.setTableName(expectBean.getTableName());
            List<String> columns = expectBean.getColumns();
            st.addAllColumns(columns);
            List<Map<String, String>> dataResult = simpleMybatisMapper.select(st);
            List<Map<String, String>> target = new ArrayList<>();
            List<List<String>> rows = expectBean.getRows();
            for (List<String> row : rows) {
                Map<String, String> rowMap = new HashMap<>();
                for (int j = 0; j < columns.size(); j++) {
                    rowMap.put(columns.get(j), row.get(j));
                }
                target.add(rowMap);
            }
            // 取预期和结果的差集
            List<Map<String, String>> diff = CollectionDiff.listDiff(target, dataResult);
            // 差集存在则测试失败
            if (diff.size() > 0) {
                // 第几行出错
                for (int j = 0; j < target.size(); j++) {
                    Map<String, String> rowMap = target.get(j);
                    boolean exist = false;
                    for (Map<String, String> diffRow : diff) {
                        boolean eq = true;
                        // 某行对比  每个字段都相等时,则认为这一行相等.
                        for (String key : columns) {
                            String value = rowMap.get(key);
                            String diffValue = diffRow.get(key);
                            if (value == null && diffValue == null) {
                                // 都为null时,这个字段相等
                                eq = true;
                            } else if (value != null && !value.equals(diffValue)) {
                                // 某个字段不为null 并且 不相等 则这一行不相等.
                                eq = false;
                                break;
                            }
                        }
                        // 某行相等则跳过
                        if (eq) {
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        logger.error("table : {} , line {} \n" + "存在差异\n" + "Exist difference", expectBean.getTableName(), j);
                        logger.error(rowMap.toString());
                    }

                }
                return false;
            }

        }

        return true;
    }

    /**
     * 打印结果. 这个东西.是打还是不打好?
     *
     * @param result 预处理数据插入结果
     */
    protected void printPrepare(List<SimpleTable> result) {
        if (result != null && result.size() != 0) {
            for (SimpleTable simpleTable : result) {
                logger.debug("Prepare table name : {}", simpleTable.getTableName());
                Map<String, Object> row = simpleTable.getRow();
                logger.debug("Prepare id : {}", simpleTable.getId());
            }
        }
    }

}
