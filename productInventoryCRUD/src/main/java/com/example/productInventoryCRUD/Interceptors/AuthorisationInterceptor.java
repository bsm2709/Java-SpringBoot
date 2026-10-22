package com.example.productInventoryCRUD.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorisationInterceptor implements HandlerInterceptor {

    @Override
    public  boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler)
            throws Exception {
        System.out.println("Entering Authorisation Interceptor");
        String role = request.getHeader("Role");

        //This will check that role in request header is Admin or not to perform only delete option we use it (on detelte method only in Product Controller) this can be done in config class
        if(role == null || !role.equals("Admin")){
            System.out.println("You are not allowed to Perform this action");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("You are not allowed to Perform this action");
            return false;
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex) throws Exception {

        System.out.println("Exiting Authorisation Interceptor");
    }
}
