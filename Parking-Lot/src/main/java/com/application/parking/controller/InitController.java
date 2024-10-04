package com.application.parking.controller;

import com.application.parking.model.ParkingLot;
import com.application.parking.service.InitService;
import com.application.parking.service.strategy.bill.BillGenerationType;
import com.application.parking.service.strategy.parkingslot.ParkingSlotAssignmentStrategyType;

public class InitController {
    private InitService initService;

    public InitController(InitService initService) {
        this.initService = initService;
    }

    public ParkingLot init(int capacity, ParkingSlotAssignmentStrategyType slotAssignmentStrategyType, BillGenerationType billGenerationType) {
        return initService.getParkingLot(capacity, slotAssignmentStrategyType, billGenerationType);
    }

    public void printParkingLot(){
        initService.printParkingLot();
    }

    public void displayAvailableFloor(){
        initService.displayAvailableFloor();
    }

}
