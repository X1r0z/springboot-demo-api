package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Result <T>{
    private int code;
    private String message;
    private T data;

    public Result(T data){
        this.code = 200;
        this.message = "success";
        this.data = data;
    }
    public Result(int code, String message){
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
