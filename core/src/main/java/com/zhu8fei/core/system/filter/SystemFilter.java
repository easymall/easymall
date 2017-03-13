package com.zhu8fei.core.system.filter;

import com.zhu8fei.core.system.SystemContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhu8fei on 2017/3/10.
 * <p>
 * 系统日志
 */
public class SystemFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        SystemContext.setUserId(1L);
        filterChain.doFilter(request,response);
        SystemContext.clean();
    }

    public void destroy() {

    }
}
