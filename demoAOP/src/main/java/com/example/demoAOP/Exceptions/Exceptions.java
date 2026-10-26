package com.example.demoAOP.Exceptions;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exceptions {

    @ExceptionHandler(Exception.class)
    public String globalExceptionHandler(Exception ex){
        return "Something is wrong";
    }

    @ExceptionHandler(RuntimeException.class)
    public String runTimeExceptionHandler(RuntimeException ex){
        return "Exception in Runtime";
    }

}
