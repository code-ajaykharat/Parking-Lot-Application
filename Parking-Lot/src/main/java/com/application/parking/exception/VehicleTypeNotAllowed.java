package com.application.parking.exception;

public class VehicleTypeNotAllowed extends RuntimeException{
    public VehicleTypeNotAllowed() {
    }

    public VehicleTypeNotAllowed(String message) {
        super(message);
    }

    public VehicleTypeNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleTypeNotAllowed(Throwable cause) {
        super(cause);
    }

    public VehicleTypeNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
