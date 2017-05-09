package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.BaseTransactionalSpringTest;
import com.zhu8fei.framework.test.commons.annotation.DataSet;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Test;

/**
 * Created by cwx on 2017/5/9.
 */
@MarkTestTarget
public class SimpleJsonFileProcessorIpmlTest extends BaseTransactionalSpringTest {
    @DataSet(value = "{}", log = true)
    @Test
    public void DataSetAnnotationTest() {

    }
}