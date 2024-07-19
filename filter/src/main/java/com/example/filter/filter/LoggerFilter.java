package com.example.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
//@Component
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 진입전
        log.info(">>>>> 진입전");

        var req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        filterChain.doFilter(req, res);

        var reqJson = new String(req.getContentAsByteArray());
        log.info("req : {}", reqJson);
        var resJson = new String(res.getContentAsByteArray());
        log.info("res : {}", resJson);

        // 진입후
        log.info("<<<<< 리턴");

        // 이전에 읽은 경우 내용이 비어있기 때문에 덮어줘야함.
        res.copyBodyToResponse();
    }
}
