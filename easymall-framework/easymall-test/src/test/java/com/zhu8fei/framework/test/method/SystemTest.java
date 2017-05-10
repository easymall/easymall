package com.zhu8fei.framework.test.method;

import com.zhu8fei.framework.TestAll;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.system.MavenPropertyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

        MavenPropertyTest.class, MavenPropertyTest.class

})
@MarkTestTarget(TestAll.class)
public class SystemTest {
}
