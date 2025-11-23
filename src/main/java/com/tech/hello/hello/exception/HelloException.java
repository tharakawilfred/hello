package com.tech.hello.hello.exception;

import lombok.Data;

@Data
public class HelloException extends RuntimeException{
    private final String error;

    public HelloException (String error) {
        this.error = error;
    }
}