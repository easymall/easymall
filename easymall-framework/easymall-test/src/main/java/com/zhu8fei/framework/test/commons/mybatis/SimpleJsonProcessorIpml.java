package com.zhu8fei.framework.test.commons.mybatis;

import com.alibaba.fastjson.JSON;
import com.zhu8fei.framework.core.exception.EasyMallCoreException;
import com.zhu8fei.framework.core.lang.SimpleFileReader;
import com.zhu8fei.framework.test.commons.annotation.DataUtils;
import com.zhu8fei.framework.test.commons.excel.EasyMallTestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhu8fei on 2017/5/6.
 */
@Service
public class SimpleJsonProcessorIpml implements MybatisTestProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource(name = "simpleMybatisMapper")
    private SimpleMybatisMapper simpleMybatisMapper;

    @Override
    public void dataInsert(Method method) throws EasyMallTestException {
        String path = DataUtils.dataSetFileName(method);
        String context;
        try {
            context = SimpleFileReader.readAnFileContext(path);
            logger.debug("Json file context : {}", context);
            DataJsonBean bean = JSON.parseObject(context, DataJsonBean.class);
            logger.debug("DataJsonBean format result : {}", bean);
            List<PrepareBean> prepares = bean.getPrepare();
            logger.debug("批量插入预处理数据.");

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
            }
            // FIXME 2017年5月9日00:05 被老婆糊一脸唾沫. 不能睡这么晚.不能天天喊你早睡.
        } catch (EasyMallCoreException e) {
            logger.error(e.getMessage(), e);
            throw new EasyMallTestException(e.getMessage(), e);
        }

    }

    @Override
    public DataCompareResult compareResult(Method method) throws EasyMallTestException {


        return null;
    }

}
