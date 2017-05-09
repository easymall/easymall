package com.zhu8fei.framework.test.method;

import com.zhu8fei.framework.TestAll;
import com.zhu8fei.framework.test.commons.mybatis.SimpleMybatisSqlProviderSpringTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by cwx on 2017/5/9.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

        SimpleMybatisSqlProviderSpringTest.class

})
@MarkTestTarget(TestAll.class)
public class PrepareAndExpectSqlTest {
}
