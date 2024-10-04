package com.application.parking.dto.request;

import com.application.parking.model.enums.VehicleType;

public class TokenRequest {
    private String userName;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String floorNumber;

    public TokenRequest(){}

    public TokenRequest(String userName, String vehicleNumber, VehicleType vehicleType, String floorNumber) {
        this.userName = userName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.floorNumber = floorNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }
}
