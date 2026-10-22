package com.example.productInventoryCRUD.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public  boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler)
            throws Exception {
        System.out.println("Entering Authentication Interceptor");

        //if key is present with correct value in request header then he is valid user
        String key = request.getHeader("x-secret-key");
        if(key == null || !key.equals("12345")){
            System.out.println("Not a valid user");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("This is not a valid USER");
            return false;
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex) throws Exception {

        System.out.println("Exiting Authentication Interceptor");
    }
}
