package com.example.ProfilesAndFiltersBasics.Filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.LogRecord;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {


        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;


        //To simply check authentication using any header values (just for example)
        String key =httpRequest.getHeader("key");

        if(!Objects.equals(key, "123456")){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }


        System.out.println("Entered Filter 1 --> Authentication Filter");
        System.out.println(key);
        System.out.println();
        chain.doFilter(request,response);

        System.out.println("Exited Filter 1 --> Authentication Filter");


    }
}
