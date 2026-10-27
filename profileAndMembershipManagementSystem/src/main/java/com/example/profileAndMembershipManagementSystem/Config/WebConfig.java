package com.example.profileAndMembershipManagementSystem.Config;

import com.example.profileAndMembershipManagementSystem.Interceptors.AuthenticationInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    AuthenticationInterceptors authenticationInterceptors;

    public WebConfig(AuthenticationInterceptors authenticationInterceptors){
        this.authenticationInterceptors =authenticationInterceptors;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptors)
                .addPathPatterns("/api/users/alterActive/**")
                .order(1);
    }

}
