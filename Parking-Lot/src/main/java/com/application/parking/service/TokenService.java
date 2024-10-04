package com.application.parking.service;

import com.application.parking.dto.response.TokenResponse;
import com.application.parking.exception.ParkingFloorNotFoundException;
import com.application.parking.exception.ParkingLotFullException;
import com.application.parking.model.*;
import com.application.parking.model.enums.ParkingSlotStatus;
import com.application.parking.model.enums.RequestStatus;
import com.application.parking.model.enums.TokenStatus;
import com.application.parking.model.enums.VehicleType;
import com.application.parking.repository.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TokenService {
    private TokenRepository tokenRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSlotRepository parkingSlotRepository;

    public TokenService(TokenRepository tokenRepository, ParkingLotRepository parkingLotRepository, VehicleRepository vehicleRepository, ParkingFloorRepository parkingFloorRepository, ParkingSlotRepository parkingSlotRepository) {
        this.tokenRepository = tokenRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public Optional<Token> generateToken(String userName, String vehicleNumber, VehicleType vehicleType, String floorNumber) {
        Token token = new Token();

        //check if vehicle already exist
        Optional<Vehicle> vehicle = vehicleRepository.findByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(vehicle.isPresent()) {
            savedVehicle = vehicle.get();
        }else{
            Vehicle vehicleNew = new Vehicle();
            vehicleNew.setType(vehicleType);
            vehicleNew.setNumber(vehicleNumber);
            vehicleNew.setOwnerName(userName);
            savedVehicle =vehicleRepository.save(vehicleNew);
        }


        ParkingLot parkingLot = parkingLotRepository.findById(1);
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        Optional<ParkingFloor> parkingFloor = Optional.empty();
        for(ParkingFloor parkingFloor1 : parkingFloors) {
            if(parkingFloor1.getNumber().equals(floorNumber)) {
                parkingFloor = Optional.ofNullable(parkingFloor1);
            }
        }

        Optional<ParkingSlot> parkingSlot = Optional.empty();
        if(parkingFloor.isPresent()) {
            parkingSlot = parkingLot.getSlotAssignmentStrategy().assign(parkingFloor.get(), savedVehicle);
        }else{
            throw new ParkingFloorNotFoundException("Please enter a valid parking floor!");
        }

        if(parkingSlot.isPresent()) {
            parkingSlot.get().setStatus(ParkingSlotStatus.OCCUPIED);
            parkingSlot.get().setCurrentVehicle(savedVehicle);
            token.setAssignedSlot(parkingSlot.get());
        }else{
            throw new ParkingLotFullException("Parking Floor Full! Please visit other floor!");
        }

        token.setVehicle(savedVehicle);
        token.setStatus(TokenStatus.ACTIVE);
        token.setEntryTime(LocalDateTime.now());
        token.setFloorNumber(floorNumber);

        parkingLotRepository.save(parkingLot);
        parkingFloorRepository.save(parkingFloor.get());
        parkingSlotRepository.save(parkingSlot.get());
        tokenRepository.save(token);

        return Optional.ofNullable(token);
    }

    public void printToken(TokenResponse tokenResponse) {
        if(tokenResponse.getRequestStatus() == RequestStatus.SUCCESS){
            String border = "+---------------------------------------+";
            String title = "|             TOKEN RECEIPT            |";

            System.out.println(border);
            System.out.println(title);
            System.out.println(border);
            System.out.printf("| %-15s: %-20s |\n", "Name", tokenResponse.getToken().getVehicle().getOwnerName());
            System.out.printf("| %-15s: %-20s |\n", "Vehicle No", tokenResponse.getToken().getVehicle().getNumber());
            System.out.printf("| %-15s: %-20s |\n", "Time", tokenResponse.getToken().getEntryTime());
            System.out.printf("| %-15s: %-20s |\n", "Slot No", tokenResponse.getToken().getAssignedSlot().getNumber());
            System.out.println(border);
            System.out.println("|          Enjoy the ride!     |");
            System.out.println(border);
        }
    }

    public boolean checkVehicleTypeAllowedOnFloorOrNot(VehicleType vehicleType, String floorNumber) {
        ParkingFloor parkingFloor = parkingFloorRepository.findByFloorNumber(floorNumber);
        List<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
        for(ParkingSlot parkingSlot : parkingSlots) {
            if(parkingSlot.getAllowedVehicleType().equals(vehicleType)) {
                return true;
            }
        }
        return false;
    }
}
