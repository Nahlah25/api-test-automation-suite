package com.domain.erp.qa.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseData {

    private int statusCode;
    private String message;
    private LoginResponseDatapojo data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginResponseDatapojo getData() {
        return data;
    }

    public void setData(LoginResponseDatapojo data) {
        this.data = data;
    }
}