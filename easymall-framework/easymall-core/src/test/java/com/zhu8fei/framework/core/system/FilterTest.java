package com.zhu8fei.framework.core.system;

import com.zhu8fei.framework.test.commons.BaseSpringBootTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@MarkTestTarget
public class FilterTest extends BaseSpringBootTest {
    @Test
    public void request() throws Exception {
        logger.info("spring boot test");
        mvc.perform(MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("hello")));
    }
}
