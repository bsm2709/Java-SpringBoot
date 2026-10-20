package com.example.ProfilesAndFiltersBasics.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

//@Component
//@Order(2)
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

        //Create 1 unique requestID and send it to reponse header
        String uuid= UUID.randomUUID().toString();
        httpResponse.setHeader("Request-ID",uuid);


//        //Try to read request body there is no such  method as .getRequestbody   so go with .getReader()   or .getInputStream()  because boths store request body in stream
//        //MAIN NOTE ::: keep in mind that Readerbody once read will be wanished and only null will be forwarded to Controller (if u are expecting to take requestbody and convert to object ) then it will give error
//        //Because once u read requestbody it is wanished.   Spring will  not store the values
//        BufferedReader readerBody = httpRequest.getReader();
//
//        //To store Full data
//        StringBuilder TotalData = new StringBuilder();
//
//        //To read body line by line
//        String Line = readerBody.readLine();
//        while(Line == null){
//            TotalData.append(Line);
//            System.out.println(Line);
//            Line = readerBody.readLine();
//        }
//
//        //Print on console
//        System.out.println(TotalData);



        chain.doFilter(request,response);

        System.out.println("Exiting the Logging filter");



    }
}
