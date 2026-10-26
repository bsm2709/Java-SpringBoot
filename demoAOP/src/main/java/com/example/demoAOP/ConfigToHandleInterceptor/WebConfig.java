//package com.example.demoAOP.ConfigToHandleInterceptor;
//
//import com.example.demoAOP.Interceptors.AuthenticationInterceptor;
//import com.example.demoAOP.Interceptors.LoggingInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    AuthenticationInterceptor authenticationInterceptor;
//    LoggingInterceptor loggingInterceptor;
//
//    public WebConfig(AuthenticationInterceptor authenticationInterceptor, LoggingInterceptor loggingInterceptor){
//        this.authenticationInterceptor = authenticationInterceptor;
//        this.loggingInterceptor = loggingInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(authenticationInterceptor)
//                .addPathPatterns("/api/students")
//                .order(1);
//
//        registry.addInterceptor(loggingInterceptor)
//                .addPathPatterns("/api/students")
//                .order(2);
//    }
//
//}
