package com.zhu8fei.framework;

import com.zhu8fei.framework.core.test.method.LangTest;
import com.zhu8fei.framework.test.commons.utils.FindNotMakeTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import com.zhu8fei.framework.test.method.PrepareAndExpectSqlTest;
import com.zhu8fei.framework.test.method.SystemTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({

        FindNotMakeTest.class, LangTest.class,

        PrepareAndExpectSqlTest.class, MethodTest.class,

        SystemTest.class

})
@MarkTestTarget({MarkTestTarget.class})
public class TestAll {

}
