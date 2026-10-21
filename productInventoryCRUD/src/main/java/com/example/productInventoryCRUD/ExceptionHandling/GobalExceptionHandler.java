package com.example.productInventoryCRUD.ExceptionHandling;

import com.example.productInventoryCRUD.Dtos.CreateProductDto.ExceptionDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GobalExceptionHandler {

    //if no one error matches it will execute this one
    //Safety net
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> gobalException (Exception ex){
        ExceptionDto exceptionResponseDto =new ExceptionDto(LocalDateTime.now(), HttpStatusCode.valueOf(500).value(), ex.getMessage());

        return ResponseEntity.internalServerError().body(exceptionResponseDto);
    }

    //Handles all Runtime Errors
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> runException (RuntimeException ex){
        ExceptionDto exceptionResponseDto =new ExceptionDto(LocalDateTime.now(), HttpStatusCode.valueOf(500).value(), ex.getMessage());

        return ResponseEntity.internalServerError().body(exceptionResponseDto);
    }

    //Handles item not found exception
    @ExceptionHandler(ItemNotFound.class)
    public ResponseEntity<ExceptionDto> itemNotFound (ItemNotFound ex){
        ExceptionDto exceptionResponseDto =new ExceptionDto(LocalDateTime.now(), HttpStatusCode.valueOf(404).value(), ex.getMessage());
        return ResponseEntity.status(404).body(exceptionResponseDto);
    }
}
