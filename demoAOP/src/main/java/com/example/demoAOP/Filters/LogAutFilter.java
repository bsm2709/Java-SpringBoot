//package com.example.demoAOP.Filters;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class LogAutFilter extends OncePerRequestFilter {
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        String key = request.getHeader("x-key");
//
//        if (key == null || !key.equals("12345")){
//            throw new RuntimeException("Authentication failed");
////            return true;
//        }
//        return false;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        //Check authentication
//        System.out.println("Key is entered correctly...");
//
//        //Logs
//        System.out.println("Request URL: "+ request.getRequestURL());
//        System.out.println("Request URI: "+ request.getRequestURI());
//        System.out.println("Request Method: "+ request.getMethod());
//        System.out.println("Request Key: "+ request.getHeader("x-key"));
//        System.out.println("IP Address: "+ request.getRemoteAddr());
//
//        //Send forward
//        filterChain.doFilter(request, response);
//
//    }
//}
