package com.application.parking.service.strategy;

import com.application.parking.model.ParkingLot;
import com.application.parking.model.ParkingSlot;
import com.application.parking.model.Vehicle;

public interface ParkingSlotAssignmentStrategy {
    ParkingSlot assign(ParkingLot parkingLot, Vehicle vehicle);
}
