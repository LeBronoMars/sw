package com.denr.solidwaste.api;

public class ApiErrorDto {

    private String message;

    public ApiErrorDto() {
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
