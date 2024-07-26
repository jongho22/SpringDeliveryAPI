package com.example.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class OpenApiInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);

        log.info("pre handle");

        var handlerMethod = (HandlerMethod) handler;

        // 메소드에 어노테이션이 달려있는지 확인
        var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class);
        if (methodLevel != null){
            log.info("method level is openApi");
            return true;
        }

        // 클래스에 어노테이션이 달려있는지 확인
        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class);
        if (classLevel != null){
            log.info("class level is openApi");
            return true;
        }
        // controller 전달, false => 전달하지 않음
        log.info("open api 아닙니다 : {}", request.getRequestURI());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        log.info("post handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        log.info("after completion");
    }
}
