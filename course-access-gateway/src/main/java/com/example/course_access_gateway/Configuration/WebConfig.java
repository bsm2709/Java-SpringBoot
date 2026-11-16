package com.example.course_access_gateway.Configuration;

import com.example.course_access_gateway.Interfaces.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    AuthInterceptor authInterceptor;

    public WebConfig(AuthInterceptor authInterceptor){
        this.authInterceptor = authInterceptor;
    }

    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/**")
                .order(1);

    }
}
