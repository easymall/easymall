package com.zhu8fei.framework.test.commons;

import com.zhu8fei.framework.test.commons.utils.FindNotMakeTestClass;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({FindNotMakeTestClass.class})
@MarkTestTarget(testType = {"MakeTestType"})
public class TestAll {

}
