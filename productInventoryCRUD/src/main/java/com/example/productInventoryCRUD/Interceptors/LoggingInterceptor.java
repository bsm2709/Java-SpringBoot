package com.example.productInventoryCRUD.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public  boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler)
            throws Exception {
        //Log or print the details on console
        System.out.println("Entering Logging Interceptor");
        System.out.println("Request URL: "+ request.getRequestURL());
        System.out.println("Request URI: "+ request.getRequestURI());
        System.out.println("Request Method: "+ request.getMethod());
        System.out.println("IP Address: "+ request.getRemoteAddr());
        System.out.println("Role of the user: "+ request.getHeader("Role"));

        if(handler instanceof HandlerMethod handlerMethod){
            System.out.println("Controller called: "+ handlerMethod.getBeanType().getName());
            System.out.println("Controller method called: "+ handlerMethod.getMethod().getName());
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                 @Nullable Exception ex) throws Exception {

        //Log or print details on console
        System.out.println("Response Status: "+ response.getStatus());
        System.out.println("Exiting Logging Interceptor");
    }

}
