package com.example.CrudDB.Config;

import com.example.CrudDB.Interceptors.AuthenticationInterceptor;
import com.example.CrudDB.Interceptors.LoggingInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //Decalre it
    LoggingInterceptors loggingInterceptors;
    AuthenticationInterceptor authenticationInterceptor;

    //Autowire
    public WebConfig(LoggingInterceptors loggingInterceptors, AuthenticationInterceptor authenticationInterceptor){
        this.loggingInterceptors = loggingInterceptors;
        this.authenticationInterceptor = authenticationInterceptor;
    }

    //Use it by overriding this Method
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptors)
                .addPathPatterns("/api/**")
                .order(2);

        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .order(1);
    }
}
