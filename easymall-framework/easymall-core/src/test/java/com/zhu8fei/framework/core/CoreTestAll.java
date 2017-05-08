package com.zhu8fei.framework.core;

import com.zhu8fei.framework.core.test.method.LangTest;
import com.zhu8fei.framework.core.utils.FindNotMakeTestClass;
import com.zhu8fei.framework.core.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/7.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({LangTest.class, FindNotMakeTestClass.class})
@MarkTestTarget(MarkTestTarget.class)
public class CoreTestAll {
}
