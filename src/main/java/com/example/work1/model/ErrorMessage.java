package com.example.work1.model;

import lombok.Data;

@Data
public class ErrorMessage {
    private int code;
    private String message;

    private ErrorMessage(){}

    public ErrorMessage(int code, String message){
        this.code = code;
        this.message = message;
    }
}
