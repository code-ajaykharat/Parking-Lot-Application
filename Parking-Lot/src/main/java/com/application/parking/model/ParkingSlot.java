package com.application.parking.model;

import com.application.parking.model.enums.ParkingSlotStatus;
import com.application.parking.model.enums.VehicleType;

public class ParkingSlot extends BaseModel{
    private String number;
    private VehicleType allowedVehicleType;
    private Vehicle currentVehicle;
    private ParkingSlotStatus status;

    public ParkingSlot(){

    }
    public ParkingSlot(String number, VehicleType allowedVehicleType, Vehicle currentVehicle, ParkingSlotStatus status) {
        this.number = number;
        this.allowedVehicleType = allowedVehicleType;
        this.currentVehicle = currentVehicle;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }

    public void setAllowedVehicleType(VehicleType allowedVehicleType) {
        this.allowedVehicleType = allowedVehicleType;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }
}
