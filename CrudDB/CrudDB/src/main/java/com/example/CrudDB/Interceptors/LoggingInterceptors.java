package com.example.CrudDB.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {


        System.out.println("Entering into Logging Interceptors -------------");
        System.out.println("Request URI: "+ request.getRequestURI());
        System.out.println("Request URL: "+request.getRequestURL());
        System.out.println("Request Method: "+ request.getMethod());
        System.out.println("Request header-Key: "+request.getHeader("x-key"));
        System.out.println("Reuest IP Address: "+ request.getRemoteAddr());

        //Logging Details
        if(handler instanceof HandlerMethod handlerMethod){
            //Some details of controllers
            System.out.println("Controller called: "+handlerMethod.getBeanType().getName());
            System.out.println("Controller Method: "+handlerMethod.getMethod());

        }

        return true;
    }

    //Its ok if we dont override it because it is default
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {

        //Not Used much
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        //Printing or Logging Response status
        System.out.println("Response Status: "+response.getStatus());
        System.out.println("Exiting from Logging Interceptors -------------");


    }
}
