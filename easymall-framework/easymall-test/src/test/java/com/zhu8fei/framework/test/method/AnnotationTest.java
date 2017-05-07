package com.zhu8fei.framework.test.method;

import com.zhu8fei.framework.test.TestAll;
import com.zhu8fei.framework.test.commons.annotation.DataUtilsTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/7.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({DataUtilsTest.class})
@MarkTestTarget(TestAll.class)
public class AnnotationTest {
}
