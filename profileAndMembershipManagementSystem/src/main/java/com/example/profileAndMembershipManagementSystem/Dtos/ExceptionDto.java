package com.example.profileAndMembershipManagementSystem.Dtos;

import jakarta.servlet.http.HttpServletResponse;

public class ExceptionDto {
    private String timestamp;
    private int status;
    private String error;


    public ExceptionDto(String timestamp, int status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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
