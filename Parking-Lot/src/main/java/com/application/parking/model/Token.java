package com.application.parking.model;

import com.application.parking.model.enums.TokenStatus;

import java.time.LocalDateTime;

public class Token extends BaseModel {
    private ParkingSlot assignedSlot;
    private Vehicle vehicle;
    private String floorNumber;
    private LocalDateTime entryTime;
    private TokenStatus status;

    public Token() {
    }

    public Token(ParkingSlot assignedSlot, Vehicle vehicle, String floorNumber, LocalDateTime entryTime, TokenStatus status) {
        this.assignedSlot = assignedSlot;
        this.vehicle = vehicle;
        this.floorNumber = floorNumber;
        this.entryTime = entryTime;
        this.status = status;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public TokenStatus getStatus() {
        return status;
    }

    public void setStatus(TokenStatus status) {
        this.status = status;
    }

    public ParkingSlot getAssignedSlot() {
        return assignedSlot;
    }

    public void setAssignedSlot(ParkingSlot assignedSlot) {
        this.assignedSlot = assignedSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
}
