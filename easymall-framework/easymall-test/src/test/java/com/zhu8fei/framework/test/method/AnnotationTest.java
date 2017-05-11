package com.zhu8fei.framework.test.method;

import com.zhu8fei.framework.EasyMallTestAll;
import com.zhu8fei.framework.test.commons.annotation.DataSetAnnotationUtilsJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/7.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({DataSetAnnotationUtilsJunitTest.class})
@MarkTestTarget(EasyMallTestAll.class)
public class AnnotationTest {
}
