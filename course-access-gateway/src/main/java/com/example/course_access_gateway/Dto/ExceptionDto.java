package com.example.course_access_gateway.Dto;

import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public class ExceptionDto {

    private LocalDateTime timestamp;
    private HttpStatusCode status;
    private String error;

    public ExceptionDto(){}

    public ExceptionDto(LocalDateTime timestamp, HttpStatusCode status, String error) {
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

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
