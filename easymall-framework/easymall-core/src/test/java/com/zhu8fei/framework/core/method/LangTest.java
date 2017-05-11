package com.zhu8fei.framework.core.method;


import com.zhu8fei.framework.EasyMallCoreTestAll;
import com.zhu8fei.framework.core.lang.FileUtilsTest;
import com.zhu8fei.framework.core.lang.SimpleFileReaderJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zhu8fei on 2017/5/7.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

        SimpleFileReaderJunitTest.class , FileUtilsTest.class

})
@MarkTestTarget(EasyMallCoreTestAll.class)
public class LangTest {

}
