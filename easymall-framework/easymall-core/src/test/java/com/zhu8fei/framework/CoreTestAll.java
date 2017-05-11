package com.zhu8fei.framework;

import com.zhu8fei.framework.core.method.LangTest;
import com.zhu8fei.framework.core.method.SystemTest;
import com.zhu8fei.framework.test.commons.utils.FindNotMakeTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by zhu8fei on 2017/5/10.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({

        LangTest.class, SystemTest.class, FindNotMakeTest.class

})
@ActiveProfiles("test")
@MarkTestTarget({MarkTestTarget.class})
public class CoreTestAll {
}
