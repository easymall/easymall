package com.zhu8fei.framework.core.system.filter;

import com.zhu8fei.framework.core.system.SystemContext;
import com.zhu8fei.framework.core.system.trace.Trace;
import org.slf4j.MDC;

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
        // 目前只生成线程编号.
        Trace trace = new Trace();
        SystemContext.setTrace(trace.getThreadTrace());
        MDC.put("Trace", SystemContext.getTrace());
        System.out.println("  filer is running  ");
        filterChain.doFilter(request, response);
        MDC.clear();
        SystemContext.clean();
    }

    public void destroy() {

    }
}
