package com.application.parking.exception;

public class ParkingLotFullException extends RuntimeException{
    public ParkingLotFullException() {
    }

    public ParkingLotFullException(String message) {
        super(message);
    }

    public ParkingLotFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingLotFullException(Throwable cause) {
        super(cause);
    }

    public ParkingLotFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
