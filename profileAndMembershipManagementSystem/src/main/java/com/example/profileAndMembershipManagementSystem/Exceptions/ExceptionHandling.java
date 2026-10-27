package com.example.profileAndMembershipManagementSystem.Exceptions;

import com.example.profileAndMembershipManagementSystem.Dtos.ExceptionDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(Exception.class)
    public ExceptionDto handleGlobalException(Exception ex){
        ExceptionDto exceptionDto = new ExceptionDto(String.valueOf(LocalDateTime.now()), HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        return exceptionDto;
    }

    @ExceptionHandler(RuntimeException.class)
    public ExceptionDto handleRuntimeException(RuntimeException ex){
        ExceptionDto exceptionDto = new ExceptionDto(String.valueOf(LocalDateTime.now()), HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        return exceptionDto;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ExceptionDto handleNotFound(UserNotFoundException ex){
        ExceptionDto exceptionDto = new ExceptionDto(String.valueOf(LocalDateTime.now()), HttpServletResponse.SC_NOT_FOUND, ex.getMessage());
        return exceptionDto;
    }
}
