package com.application.parking.model;

import com.application.parking.model.enums.ParkingLotStatus;
import com.application.parking.model.enums.VehicleType;
import com.application.parking.service.strategy.bill.BillGenerationStrategy;
import com.application.parking.service.strategy.bill.BillGenerationStrategyFactory;
import com.application.parking.service.strategy.bill.BillGenerationType;
import com.application.parking.service.strategy.parkingslot.ParkingSlotAssignmentStrategy;
import com.application.parking.service.strategy.parkingslot.ParkingSlotAssignmentStrategyFactory;
import com.application.parking.service.strategy.parkingslot.ParkingSlotAssignmentStrategyType;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<VehicleType> vehicleTypes;
    private ParkingLotStatus status;
    private int capacity;
    private ParkingSlotAssignmentStrategy slotAssignmentStrategy;
    private BillGenerationStrategy billGenerationStrategy;

    public ParkingLot(){

    }

    public ParkingLot(String name, String address, List<ParkingFloor> parkingFloors, List<VehicleType> vehicleTypes, ParkingLotStatus status, int capacity, ParkingSlotAssignmentStrategyType slotAssignmentStrategyType, BillGenerationType billGenerationStrategyType) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.vehicleTypes = vehicleTypes;
        this.status = status;
        this.capacity = capacity;
        this.slotAssignmentStrategy = ParkingSlotAssignmentStrategyFactory.getParkingSlotAssignmentStrategy(slotAssignmentStrategyType);
        this.billGenerationStrategy = BillGenerationStrategyFactory.getBillGenerationStrategy(billGenerationStrategyType);
    }

    public ParkingSlotAssignmentStrategy getSlotAssignmentStrategy() {
        return slotAssignmentStrategy;
    }

    public void setSlotAssignmentStrategy(ParkingSlotAssignmentStrategyType slotAssignmentStrategyType) {
        this.slotAssignmentStrategy = ParkingSlotAssignmentStrategyFactory.getParkingSlotAssignmentStrategy(slotAssignmentStrategyType);
    }

    public BillGenerationStrategy getBillGenerationStrategy() {
        return billGenerationStrategy;
    }

    public void setBillGenerationStrategy(BillGenerationType billGenerationStrategyType) {
        this.billGenerationStrategy = BillGenerationStrategyFactory.getBillGenerationStrategy(billGenerationStrategyType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
