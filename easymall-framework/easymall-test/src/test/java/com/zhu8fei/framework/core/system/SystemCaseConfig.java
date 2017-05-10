package com.zhu8fei.framework.core.system;

import com.zhu8fei.framework.core.system.filter.SystemFilter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@SpringBootConfiguration
public class SystemCaseConfig {
    @Bean
    public FilterRegistrationBean indexFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new SystemFilter());
        registration.addUrlPatterns("/");
        return registration;
    }
}
