package com.example.hrteamproject.Pojo.response;

import org.springframework.http.HttpStatus;

public class GeneralResponse {
    private HttpStatus statusCode = HttpStatus.OK;
    private Object data;
    private boolean success = true;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public GeneralResponse() {}

    public GeneralResponse(Object data) {
        this.data = data;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
