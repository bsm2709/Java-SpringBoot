package com.example.CrudDB.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String URI = request.getRequestURI();

        return !URI.startsWith("/api/student");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String key = request.getHeader("Key");

        if (key == null || !key.equals("12345")){
            //Response Status
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            //External Response Body
            response.setHeader("Error", "UnAuthorized User");
            return;
        }
        System.out.println("Key is: "+key);

        filterChain.doFilter(request, response);

    }
}
