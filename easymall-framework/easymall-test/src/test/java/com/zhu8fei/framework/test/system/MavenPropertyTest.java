package com.zhu8fei.framework.test.system;

import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.SystemTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@MarkTestTarget(SystemTest.class)
public class MavenPropertyTest extends BaseJunitTest {
    @Test
    public void getMavenProperty() {
        if (System.getProperty("isMavenRunner") == null) {
            logger.warn("这是手工启动,无论如何你也要看到这条消息");
            System.setProperty("findClassLogPath", "什么也好. 反正不能是null");
        }
        logger.info("maven pom findClassLogPath : {}", System.getProperty("findClassLogPath"));
        // findClassLogPath 为空时, 报错.
        Assert.assertNotNull("这是手工启动", System.getProperty("findClassLogPath"));
    }
}
