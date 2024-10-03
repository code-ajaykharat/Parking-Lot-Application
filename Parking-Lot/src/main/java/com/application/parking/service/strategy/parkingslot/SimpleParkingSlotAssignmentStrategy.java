package com.application.parking.service.strategy.parkingslot;

import com.application.parking.model.ParkingLot;
import com.application.parking.model.ParkingSlot;
import com.application.parking.model.Vehicle;

public class SimpleParkingSlotAssignmentStrategy implements ParkingSlotAssignmentStrategy {
    @Override
    public ParkingSlot assign(ParkingLot parkingLot, Vehicle vehicle) {
        return null;
    }
}
