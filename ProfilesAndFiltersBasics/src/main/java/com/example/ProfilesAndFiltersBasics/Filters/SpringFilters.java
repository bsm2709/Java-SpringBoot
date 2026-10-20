package com.example.ProfilesAndFiltersBasics.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class SpringFilters extends OncePerRequestFilter {

    //It ensures that this filter runs or acts only when the given url satistfied
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request)
            throws ServletException {
        String uri = request.getRequestURI();

        //returning only  uri.startsWith("/api/")  will return if we use this endpoint starting so it will not work to these then ,  so put negation on it so it will only work it it and not work to other endpoints whiv=ch dont start with /api
        return !uri.startsWith("/api");
        //It should return false then our filter will run and this method(shouldNotFilter will be off meaning return false)so now it will only run for request starts with /api/anything
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {


        //Same Logging Filter is implemented here to check special feature of springboot
        //1. we already get httpresponse and request  so dont need to typecast it again
        //2. We have somemore functions to override
        //3. filterChain works same

        //For creating and Logging
        System.out.println("Entered Logging Filter using Springboot");
        System.out.println("URI is " +request.getRequestURI());
        System.out.println("Key is "+request.getHeader("key"));
        System.out.println("Method is "+request.getMethod());

        //Create 1 unique requestID and send it to reponse header
        String uuid= UUID.randomUUID().toString();
        response.setHeader("Request-ID",uuid);

        filterChain.doFilter(request,response);

        System.out.println("Exiting the Logging filter");

    }
}
