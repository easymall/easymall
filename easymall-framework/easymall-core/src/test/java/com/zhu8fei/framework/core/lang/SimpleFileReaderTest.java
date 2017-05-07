package com.zhu8fei.framework.core.lang;

import com.zhu8fei.framework.core.test.method.LangTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhu8fei on 2017/5/7.
 */
@MarkTestTarget(LangTest.class)
public class SimpleFileReaderTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void readAnFileContext() throws Exception {
        String path = getClass().getResource("/").getFile();
        logger.info(path);
        String context = SimpleFileReader.readAnFileContext(path + "SimpleFileReader.json");
        logger.info(context);
        Assert.assertNotNull(context);
        String empty = SimpleFileReader.readAnFileContext(path + "emptyFile");
        logger.info(empty);
        Assert.assertEquals(empty, "");
    }

}