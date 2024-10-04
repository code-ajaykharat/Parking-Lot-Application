package com.application.parking.service.strategy.parkingslot;

import com.application.parking.model.ParkingFloor;
import com.application.parking.model.ParkingSlot;
import com.application.parking.model.Vehicle;

import java.util.Optional;

public interface ParkingSlotAssignmentStrategy {
    Optional<ParkingSlot> assign(ParkingFloor parkingFloor, Vehicle vehicle);
}
