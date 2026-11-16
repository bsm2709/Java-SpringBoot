package com.example.course_access_gateway.Interfaces;


import com.example.course_access_gateway.Exceptions.UnauthorizedAccessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String Token = request.getHeader("X-Auth-Token");

        if(Token == null || !Token.equals("12345")){
            throw new UnauthorizedAccessException("User not Authorized");
        }

        return true;
    }
}
