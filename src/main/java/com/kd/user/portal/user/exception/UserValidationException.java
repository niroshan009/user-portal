package com.kd.user.portal.user.exception;

public class UserValidationException extends Exception{

    private String message;

    private Throwable cause;


    public UserValidationException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }
}
