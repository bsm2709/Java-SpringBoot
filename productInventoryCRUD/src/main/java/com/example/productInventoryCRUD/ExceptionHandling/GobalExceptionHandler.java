package com.example.productInventoryCRUD.ExceptionHandling;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalExceptionHandler {

    //if no one error matches it will execute this one
    //Safety net
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> gobalException (Exception ex){

        return ResponseEntity.internalServerError().body("Something Went Wrong");
    }

    //Handles all Runtime Errors
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runException (RuntimeException ex){

        return ResponseEntity.internalServerError().body("Runtime Exception");
    }

    //Handles item not found exception
    @ExceptionHandler(ItemNotFound.class)
    public ResponseEntity<String> itemNotFound (ItemNotFound ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }





}
