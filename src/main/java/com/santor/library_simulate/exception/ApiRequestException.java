package com.santor.library_simulate.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException{


    private static final long serialVersionUID = -593928338203984611L;

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public ApiRequestException(String message, HttpStatus httpStatus) {
        new ApiException(message,httpStatus);
    }
}
