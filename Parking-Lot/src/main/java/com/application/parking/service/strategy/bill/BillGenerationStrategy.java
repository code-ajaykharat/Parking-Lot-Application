package com.application.parking.service.strategy.bill;

import com.application.parking.model.enums.VehicleType;

public interface BillGenerationStrategy {
    double generatePrice(int hours, VehicleType vehicleType);
}
