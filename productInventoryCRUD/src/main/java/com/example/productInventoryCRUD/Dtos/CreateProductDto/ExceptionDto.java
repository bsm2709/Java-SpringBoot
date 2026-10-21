package com.example.productInventoryCRUD.Dtos.CreateProductDto;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public class ExceptionDto {
    private LocalDateTime timestamp;
    private int status;
    private String error;


    public ExceptionDto(LocalDateTime timestamp, int status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;

    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}
