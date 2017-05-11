package com.zhu8fei.framework.test.commons.mybatis;

import com.zhu8fei.framework.test.commons.exception.EasyMallTestException;
import com.zhu8fei.framework.test.commons.mybatis.config.MybatisConfig;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mybatis.spring.SqlSessionFactoryBean;

import static org.mockito.Mockito.*;

/**
 * Created by zhu8fei on 2017/5/11.
 */
@MarkTestTarget(MethodTest.class)
public class MybatisConfigTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void mockInner() throws Exception {
        // mock 骗覆盖!!!
        SqlSessionFactoryBean factoryBean = mock(SqlSessionFactoryBean.class);
        // 根据mybatisConfig.sqlSessionFactoryBean 最后的try 方法块. 只有factoryBean.getObject 可能产生Exception
        // mock factoryBean.getObject 使其返回exception 并定义msg
        when(factoryBean.getObject()).thenThrow(new Exception(" this error is mock exception "));
        // spy 方法可以mock指定方法  而 mock方法产生的则是全部方法代理   两个都是cglib的代理对象.
        MybatisConfig mybatisConfig = spy(new MybatisConfig());
        // 当调用mybatisConfig.getSqlSessionFactoryBeanInstance时产生mock的factoryBean
        when(mybatisConfig.getSqlSessionFactoryBeanInstance()).thenReturn(factoryBean);
        expectedException.expect(EasyMallTestException.class);
        expectedException.expectMessage("mock exception");

        mybatisConfig.sqlSessionFactoryBean();
    }
}