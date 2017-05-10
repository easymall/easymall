package com.zhu8fei.framework.test.method;

import com.zhu8fei.framework.TestAll;
import com.zhu8fei.framework.test.commons.mybatis.ExpectBeanJunitTest;
import com.zhu8fei.framework.test.commons.mybatis.SimpleMybatisSqlProviderSpringTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.jdk.CollectionDiffTest;
import com.zhu8fei.framework.test.jdk.ExtendsTransactionalSpringTest;
import com.zhu8fei.framework.test.jdk.MethodAndClassTest;
import com.zhu8fei.framework.test.spring.SpringJunitProcessTransactionalSpringTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by cwx on 2017/5/9.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

        ExpectBeanJunitTest.class, SpringJunitProcessTransactionalSpringTest.class,

        ExtendsTransactionalSpringTest.class, SimpleMybatisSqlProviderSpringTest.class,

        MethodAndClassTest.class,CollectionDiffTest.class

})
@MarkTestTarget(TestAll.class)
public class MethodTest {
}
