package com.application.parking.model;

import java.time.LocalDateTime;

public class Token extends BaseModel{
    private ParkingSlot assignedSlot;
    private Vehicle vehicle;
    private Gate entryGate;
    private LocalDateTime entryTime;

    public Token(){}
    public Token(ParkingSlot assignedSlot, Vehicle vehicle, Gate entryGate, LocalDateTime entryTime) {
        this.assignedSlot = assignedSlot;
        this.vehicle = vehicle;
        this.entryGate = entryGate;
        this.entryTime = entryTime;
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

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
}
