package com.project3.ecommerce.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).excludePathPatterns("/user/login")
                .excludePathPatterns("/product/{id}").excludePathPatterns("/shop/{category}").excludePathPatterns("/cart")
                .excludePathPatterns("/addToCart/{id}/qty/{qty}").excludePathPatterns("/removeFromCart/{id}/qty/{qty}")
                .excludePathPatterns("/payment").excludePathPatterns("/saveInvoice").excludePathPatterns("/")
                .excludePathPatterns("/login").excludePathPatterns("/register")
                .excludePathPatterns("/user/register");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
