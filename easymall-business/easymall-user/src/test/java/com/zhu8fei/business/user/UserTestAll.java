package com.zhu8fei.business.user;

import com.zhu8fei.framework.test.commons.utils.FindNotMakeTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/6.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({FindNotMakeTest.class})
@MarkTestTarget({MarkTestTarget.class})
public class UserTestAll {
}
