package com.example.hrteamproject.Pojo.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse extends GeneralResponse{
    private String message;

    public ErrorResponse(HttpStatus status, String message) {
        super.setStatusCode(status);
        this.message = message;
        super.setSuccess(false);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
