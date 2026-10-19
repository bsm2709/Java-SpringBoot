package com.example.ProfilesAndFiltersBasics.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {



        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;



        //For creating and Logging
        System.out.println("Entered Logging Filter");
        System.out.println("URI is " +httpRequest.getRequestURI());
        System.out.println("Key is "+httpRequest.getHeader("key"));
        System.out.println("Method is "+httpRequest.getMethod());

        chain.doFilter(request,response);

        System.out.println("Exiting the Logging filter");



    }
}
