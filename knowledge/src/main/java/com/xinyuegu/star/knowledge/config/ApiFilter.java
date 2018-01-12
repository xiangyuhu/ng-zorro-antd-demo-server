package com.xinyuegu.star.knowledge.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hxy
 * @date 2017-05-09
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/**", filterName = "basicFilter")
public class ApiFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(ApiFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Content-Disposition, token, Accept");
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
