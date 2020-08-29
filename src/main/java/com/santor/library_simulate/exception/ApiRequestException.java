package com.santor.library_simulate.exception;

public class ApiRequestException extends RuntimeException{


    private static final long serialVersionUID = -593928338203984611L;

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
