package com.application.parking.model;

import com.application.parking.model.enums.ParkingFloorStatus;
import com.application.parking.model.enums.VehicleType;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private String number;
    private List<ParkingSlot> parkingSlots;
    private ParkingFloorStatus status;
    private Gate entryGate;
    private Gate exitGate;

    public ParkingFloor() {
    }

    public ParkingFloor(String number, List<ParkingSlot> parkingSlots, ParkingFloorStatus status, Gate entryGate, Gate exitGate) {
        this.number = number;
        this.parkingSlots = parkingSlots;
        this.status = status;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public ParkingFloorStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingFloorStatus status) {
        this.status = status;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
}
