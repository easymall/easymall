package com.zhu8fei.framework.core.method;

import com.zhu8fei.framework.CoreTestAll;
import com.zhu8fei.framework.core.system.FilterTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

        FilterTest.class

})
@MarkTestTarget(CoreTestAll.class)
public class SystemTest {
}
