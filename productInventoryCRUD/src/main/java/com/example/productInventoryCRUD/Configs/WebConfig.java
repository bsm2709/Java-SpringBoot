package com.example.productInventoryCRUD.Configs;

import com.example.productInventoryCRUD.Interceptors.AuthenticationInterceptor;
import com.example.productInventoryCRUD.Interceptors.AuthorisationInterceptor;
import com.example.productInventoryCRUD.Interceptors.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    LoggingInterceptor loggingInterface;
    AuthenticationInterceptor authenticationInterceptor;
    AuthorisationInterceptor authorisationInterceptor;

    public WebConfig(LoggingInterceptor loggingInterface,
                     AuthenticationInterceptor authenticationInterceptor,
                     AuthorisationInterceptor authorisationInterceptor){

        this.loggingInterface = loggingInterface;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorisationInterceptor = authorisationInterceptor;

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //These both works on all /api/ anything...
        registry.addInterceptor(loggingInterface)
                .addPathPatterns("/api/**")
                .order(3);

        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .order(1);

        //Authorisation (Admin) can only delete the products so this Interceptor works on method SoftDelete because in addPathPattern i have added the path of only that
        registry.addInterceptor(authorisationInterceptor)
                .addPathPatterns("/api/products/softDelete/**")
                .order(2);
    }

}
