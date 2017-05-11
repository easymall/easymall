package com.zhu8fei.framework.core.system;

import com.zhu8fei.framework.core.method.SystemTest;
import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

/**
 * Created by cwx on 2017/5/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@MarkTestTarget(SystemTest.class)
public class SystemContextTest extends BaseJunitTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getMap() {
        Long userId = SystemContext.getUserId();
        logger.info(String.valueOf(userId));
    }

    @Test
    public void registered() {

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("is not registered");
        SystemContext.put("", "");
    }

    @Test
    public void notValue() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("is null");
        SystemContext.put("trace_", null);
    }

    @Test
    public void longLongValue() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("value is more than");
        // WHF 250
        SystemContext.put("trace_", "12345678901234567890123456789012345678901234567890" +

                "12345678901234567890123456789012345678901234567890" +

                "12345678901234567890123456789012345678901234567890" +

                "12345678901234567890123456789012345678901234567890" +

                "12345678901234567890123456789012345678901234567890");
    }

    @Test
    public void more() {
        SystemContext.setTrace("go go go go go");
        logger.info(SystemContext.getTrace());
        SystemContext.setLocale("zh_cn");
        logger.info(SystemContext.getLocale());
        SystemContext.setUserId(250L);
        logger.info(String.valueOf(SystemContext.getUserId()));
        SystemContext.setUserName("250");
        logger.info(String.valueOf(SystemContext.getUserName()));
    }

}
