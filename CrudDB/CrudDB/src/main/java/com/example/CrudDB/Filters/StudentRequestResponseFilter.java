//package com.example.CrudDB.Filters;
//
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
////This filter will only execute if uri starts with /api/student/*
//
//@Component
//@Order(2)
//public class StudentRequestResponseFilter extends OncePerRequestFilter {
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        String URI = request.getRequestURI();
//
//        return !URI.startsWith("/api/student");
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//
//        //Just to print or log details of request and response
//        System.out.println();
//        System.out.println("Details of requests...........");
//        System.out.println("Request URI: "+ request.getRequestURI());
//        System.out.println("Request Method: "+ request.getMethod());
//        System.out.println("Request key: "+ request.getHeader("Key"));
//        System.out.println("Request URL: "+ request.getRequestURL());
//        System.out.println();
//        filterChain.doFilter(request, response);
//    }
//}
