package com.zhu8fei.framework.core.system;

import com.zhu8fei.framework.test.commons.BaseSpringTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@SpringBootTest(classes = SystemCaseConfig.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@MarkTestTarget
@Ignore
public class FilterTest extends BaseSpringTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void request() throws Exception {
        logger.info("spring boot test");
        mvc.perform(MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
}
