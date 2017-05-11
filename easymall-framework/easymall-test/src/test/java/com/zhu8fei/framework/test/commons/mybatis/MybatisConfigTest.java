package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.exception.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.config.MybatisConfig;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

/**
 * Created by cwx on 2017/5/11.
 */
@MarkTestTarget(MethodTest.class)
public class MybatisConfigTest {
    @Rule
    public ExpectedException expectedException  = ExpectedException.none();
    @Test
    public void mock() throws EasyMallTestException {
        // mock 骗覆盖???
        MybatisConfig mybatisConfig  = Mockito.mock(MybatisConfig.class);
        Mockito.when(mybatisConfig.sqlSessionFactoryBean()).thenThrow(EasyMallTestException.class);
        expectedException.expect(EasyMallTestException.class);
        mybatisConfig.sqlSessionFactoryBean();

    }
}