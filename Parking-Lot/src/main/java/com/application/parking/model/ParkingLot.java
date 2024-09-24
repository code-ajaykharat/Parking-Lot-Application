package com.application.parking.model;

import com.application.parking.model.enums.ParkingLotStatus;
import com.application.parking.model.enums.VehicleType;
import com.application.parking.service.strategy.BillGenerationStrategy;
import com.application.parking.service.strategy.ParkingSlotAssignmentStrategy;

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
    public ParkingLot(String name, String address, List<ParkingFloor> parkingFloors, List<VehicleType> vehicleTypes, ParkingLotStatus status, int capacity, ParkingSlotAssignmentStrategy slotAssignmentStrategy, BillGenerationStrategy billGenerationStrategy) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.vehicleTypes = vehicleTypes;
        this.status = status;
        this.capacity = capacity;
        this.slotAssignmentStrategy = slotAssignmentStrategy;
        this.billGenerationStrategy = billGenerationStrategy;
    }

    public ParkingSlotAssignmentStrategy getSlotAssignmentStrategy() {
        return slotAssignmentStrategy;
    }

    public void setSlotAssignmentStrategy(ParkingSlotAssignmentStrategy slotAssignmentStrategy) {
        this.slotAssignmentStrategy = slotAssignmentStrategy;
    }

    public BillGenerationStrategy getBillGenerationStrategy() {
        return billGenerationStrategy;
    }

    public void setBillGenerationStrategy(BillGenerationStrategy billGenerationStrategy) {
        this.billGenerationStrategy = billGenerationStrategy;
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
