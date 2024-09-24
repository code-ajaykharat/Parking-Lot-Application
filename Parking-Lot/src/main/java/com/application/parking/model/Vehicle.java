package com.application.parking.model;

import com.application.parking.model.enums.VehicleType;

public class Vehicle extends BaseModel{
    private String number;
    private String ownerName;
    private VehicleType type;

    public Vehicle(){}
    public Vehicle(String number, String ownerName, VehicleType type) {
        this.number = number;
        this.ownerName = ownerName;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
