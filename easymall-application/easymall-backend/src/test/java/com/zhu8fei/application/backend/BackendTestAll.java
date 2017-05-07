package com.zhu8fei.application.backend;

import com.zhu8fei.framework.test.commons.utils.FindNotMakeTestClass;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/6.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({FindNotMakeTestClass.class})
@MarkTestTarget({MarkTestTarget.class})
public class BackendTestAll {
}
