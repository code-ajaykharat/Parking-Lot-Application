package com.application.parking;

import com.application.parking.controller.BillController;
import com.application.parking.controller.InitController;
import com.application.parking.controller.TokenController;
import com.application.parking.dto.request.BillRequest;
import com.application.parking.dto.request.TokenRequest;
import com.application.parking.dto.response.BillResponse;
import com.application.parking.dto.response.TokenResponse;
import com.application.parking.model.enums.VehicleType;
import com.application.parking.repository.*;
import com.application.parking.service.BillService;
import com.application.parking.service.InitService;
import com.application.parking.service.TokenService;
import com.application.parking.service.strategy.bill.BillGenerationStrategy;
import com.application.parking.service.strategy.bill.BillGenerationType;
import com.application.parking.service.strategy.bill.SimpleBillGenerationStrategy;
import com.application.parking.service.strategy.parkingslot.ParkingSlotAssignmentStrategyType;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        BillRepository billRepository = new BillRepository();
        GateRepository gateRepository = new GateRepository();
        OperatorRepository operatorRepository = new OperatorRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        TokenRepository tokenRepository = new TokenRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        Scanner sc = new Scanner(System.in);
        InitService initService = new InitService(operatorRepository, parkingLotRepository, parkingFloorRepository, parkingSlotRepository, gateRepository);
        InitController initController = new InitController(initService);
        System.out.println("Enter Parking lot capacity: ");
        int capacity = sc.nextInt();
        initController.init(capacity, ParkingSlotAssignmentStrategyType.SIMPLE, BillGenerationType.SIMPLE);
        initController.printParkingLot();

        TokenService tokenService = new TokenService(
                tokenRepository,
                parkingLotRepository,
                vehicleRepository,
                parkingFloorRepository,
                parkingSlotRepository
        );

        BillGenerationStrategy billGenerationStrategy = new SimpleBillGenerationStrategy();
        BillService billService = new BillService(
                billGenerationStrategy,
                tokenRepository,
                billRepository
        );

        while(true) {
            System.out.println("Select Option: \n 1. Enter to Parking Lot \n 2. Exit from Parking Lot \n 3. Display Parking Lot \n 4. Exit");
            int option = sc.nextInt();
            switch(option) {
                case 1:
                    TokenController tokenController = new TokenController(tokenService);
                    TokenRequest tokenRequest = new TokenRequest();
                    initController.displayAvailableFloor();
                    System.out.println("Please enter floor number of your choice: ");
                    String floorNumber = sc.next();
                    System.out.println("Please enter owner name of vehicle: ");
                    String userName = sc.next();
                    System.out.println("Please enter vehicle number: ");
                    String vehicleNumber = sc.next();
                    System.out.println("Please enter vehicle type: ");
                    VehicleType vehicleType = VehicleType.valueOf(sc.next());
                    tokenRequest.setVehicleNumber(vehicleNumber);
                    tokenRequest.setVehicleType(vehicleType);
                    tokenRequest.setFloorNumber(floorNumber);
                    tokenRequest.setUserName(userName);
                    TokenResponse tokenResponse = tokenController.generateToken(tokenRequest);
                    tokenController.printToken(tokenResponse);
                    break;
                case 2:
                    BillController billController = new BillController(billService);
                    BillRequest billRequest = new BillRequest();
                    System.out.println("Please enter token id: ");
                    int tokenId = sc.nextInt();
                    billRequest.setTokenId(tokenId);
//                    System.out.println("Please enter exit gate number: ");
//                    String exitGateNumber = sc.next();
//                    billRequest.setExitGateNumber(exitGateNumber);
                    BillResponse billResponse = billController.generateBill(billRequest);
                    if(billResponse.getMessage() != null) {
                        System.out.println(billResponse.getMessage());
                    } else {
                        System.out.println("Bill amount: " + billResponse.getAmount());
                        System.out.println("Please pay the bill to exit the parking lot.");
                    }
                    break;
                case 3:
                    initController.printParkingLot();
                case 4:
                    System.exit(0);
            }
        }
    }
}