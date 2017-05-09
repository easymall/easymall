package com.zhu8fei.framework.test;

import com.zhu8fei.framework.core.test.method.LangTest;
import com.zhu8fei.framework.test.commons.utils.FindNotMakeTestClass;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({FindNotMakeTestClass.class, LangTest.class, MethodTest.class})
@MarkTestTarget({MarkTestTarget.class})
public class TestAll {

}
