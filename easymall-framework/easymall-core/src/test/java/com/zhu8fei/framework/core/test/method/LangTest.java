package com.zhu8fei.framework.core.test.method;

import com.zhu8fei.framework.core.CoreTestAll;
import com.zhu8fei.framework.core.lang.SimpleFileReaderTest;
import com.zhu8fei.framework.core.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/7.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({SimpleFileReaderTest.class})
@MarkTestTarget(CoreTestAll.class)
public class LangTest {

}
