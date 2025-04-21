package com.application.parking.service.strategy.bill;

import com.application.parking.model.enums.VehicleType;

public class SimpleBillGenerationStrategy implements BillGenerationStrategy {

    @Override
    public double generatePrice(int hours, VehicleType vehicleType) {
        double rate = 0;
        switch (vehicleType) {
            case CAR:
                rate = 10.0;
                break;
            case BIKE:
                rate = 5.0;
                break;
            case TRUCK:
                rate = 15.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
        return hours * rate;
    }
}
