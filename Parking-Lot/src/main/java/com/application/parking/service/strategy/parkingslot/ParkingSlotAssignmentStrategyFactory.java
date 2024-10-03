package com.application.parking.service.strategy.parkingslot;

public class ParkingSlotAssignmentStrategyFactory {
    public static ParkingSlotAssignmentStrategy getParkingSlotAssignmentStrategy(ParkingSlotAssignmentStrategyType type) {
        if(type.equals(ParkingSlotAssignmentStrategyType.SIMPLE)){
            return new SimpleParkingSlotAssignmentStrategy();
        }
        return null;
    }
}
