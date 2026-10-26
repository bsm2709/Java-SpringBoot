//package com.example.demoAOP.Interceptors;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.jspecify.annotations.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//@Component
//public class LoggingInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response,
//                             Object handler)
//            throws Exception {
//        System.out.println("Entering from LoggingInterceptors----------");
//
//        //Logging Data
//        System.out.println("Request URL: "+ request.getRequestURL());
//        System.out.println("Request URI: "+ request.getRequestURI());
//        System.out.println("Request Method: "+ request.getMethod());
//        System.out.println("Request Key: "+ request.getHeader("x-key"));
//        System.out.println("IP Address: "+ request.getRemoteAddr());
//
//        //Logging Controllers Data
//        if(handler instanceof HandlerMethod handlerMethod){
//            System.out.println("Method name: "+ handlerMethod.getMethod());
//            System.out.println("Class(Controller) name: "+ handlerMethod.getBeanType().getName());
//            System.out.println("Bean name: "+ handlerMethod.getBean());
//        }
//
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
//                                 @Nullable Exception ex) throws Exception {
//
//        System.out.println("Exiting from LoggingInterceptors----------");
//    }
//}
