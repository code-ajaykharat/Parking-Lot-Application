package com.application.parking.exception;

public class OperatorNotFoundException extends RuntimeException{
    public OperatorNotFoundException() {
    }

    public OperatorNotFoundException(String message) {
        super(message);
    }

    public OperatorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperatorNotFoundException(Throwable cause) {
        super(cause);
    }

    public OperatorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
