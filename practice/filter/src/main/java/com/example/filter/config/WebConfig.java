package com.example.filter.config;

import com.example.filter.interceptor.OpenApiInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final OpenApiInterceptor openApiInterceptor;

    // interceptor 추가
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(openApiInterceptor)
//                .addPathPatterns("/**"); // 모든 주소에다가 인터셉터를 등록.
    }
}
