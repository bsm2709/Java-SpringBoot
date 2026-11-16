package com.example.course_access_gateway.Exceptions;


import com.example.course_access_gateway.Dto.ExceptionDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionClass {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> globalException(Exception exception){

        ExceptionDto exceptionDto = new ExceptionDto(LocalDateTime.now(), HttpStatusCode.valueOf(500), exception.getMessage());
        return ResponseEntity.status(500).body(exceptionDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> runTimeException(RuntimeException runtimeException){

        ExceptionDto exceptionDto = new ExceptionDto(LocalDateTime.now(), HttpStatusCode.valueOf(500), runtimeException.getMessage());
        return ResponseEntity.status(500).body(exceptionDto);
    }

    @ExceptionHandler(ElementNotFound.class)
    public ResponseEntity<ExceptionDto> elementNotFound(ElementNotFound elementNotFound){
        ExceptionDto exceptionDto = new ExceptionDto(LocalDateTime.now(), HttpStatusCode.valueOf(404), elementNotFound.getMessage());
        return ResponseEntity.status(404).body(exceptionDto);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ExceptionDto> unauthorizedAccessException(UnauthorizedAccessException unauthorizedAccessException){
        ExceptionDto exceptionDto = new ExceptionDto(LocalDateTime.now(), HttpStatusCode.valueOf(401), unauthorizedAccessException.getMessage());
        return ResponseEntity.status(401).body(exceptionDto);
    }

}
