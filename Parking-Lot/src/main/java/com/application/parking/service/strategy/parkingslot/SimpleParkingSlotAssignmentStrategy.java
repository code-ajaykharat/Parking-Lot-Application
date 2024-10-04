package com.application.parking.service.strategy.parkingslot;

import com.application.parking.model.ParkingFloor;
import com.application.parking.model.ParkingLot;
import com.application.parking.model.ParkingSlot;
import com.application.parking.model.Vehicle;
import com.application.parking.model.enums.ParkingSlotStatus;

import java.util.Optional;

public class SimpleParkingSlotAssignmentStrategy implements ParkingSlotAssignmentStrategy {
    @Override
    public Optional<ParkingSlot> assign(ParkingFloor parkingFloor, Vehicle vehicle) {
        for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {
            if(parkingSlot != null && parkingSlot.getStatus().equals(ParkingSlotStatus.AVAILABLE) && parkingSlot.getAllowedVehicleType().equals(vehicle.getType())) {
                return Optional.ofNullable(parkingSlot);
            }
        }
        return Optional.empty();
    }
}
