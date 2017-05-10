package com.zhu8fei.framework.core.system;

import com.zhu8fei.framework.core.system.filter.SystemFilter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@Controller
@SpringBootConfiguration
public class SystemCaseConfig {
    @Bean
    public FilterRegistrationBean indexFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new SystemFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
    @RequestMapping("/test")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
