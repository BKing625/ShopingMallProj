package com.cafe24.mall.frontend.config;

import com.cafe24.security.AuthLoginInterceptor;
import com.cafe24.security.AuthLogoutInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public AuthLogoutInterceptor authLogoutInterceptor() {return new AuthLogoutInterceptor();}

    @Bean
    public AuthLoginInterceptor authLoginInterceptor() {
        return new AuthLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authLoginInterceptor())
                .addPathPatterns("/user/auth");

        registry
                .addInterceptor(authLogoutInterceptor())
                .addPathPatterns("/user/logout");

//        registry
//                .addInterceptor(authInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/user/auth")
//                .excludePathPatterns("/user/logout")
//                .excludePathPatterns("/assets/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:/Users/bking/Workspace/mallproject/mall-frontend/src/main/webapp/WEB-INF/ImageFiles/");
    }
}
