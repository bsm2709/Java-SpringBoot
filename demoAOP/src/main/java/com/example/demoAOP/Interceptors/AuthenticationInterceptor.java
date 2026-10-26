//package com.example.demoAOP.Interceptors;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.jspecify.annotations.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class AuthenticationInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response,
//                             Object handler)
//            throws Exception {
//
//        System.out.println("Entering Authentication Interceptor ------");
//       String key = request.getHeader("x-key");
//
//       if(key == null || !key.equals("12345")){
//           //U can do this because we are handling exceptions but it is good practice to add response status and send it back
//           //throw new RuntimeException("Authentication failed");
//
//           //Edit response status with message
//           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//           return false;
//       }
//
//        System.out.println("Valid User || Authentication successful");
//
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
//                                @Nullable Exception ex) throws Exception {
//
//        System.out.println("Exiting Authentication Interceptor ------");
//    }
//}
