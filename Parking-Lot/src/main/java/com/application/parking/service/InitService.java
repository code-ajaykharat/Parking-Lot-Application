package com.application.parking.service;

import com.application.parking.constant.ApplicationConstant;
import com.application.parking.model.*;
import com.application.parking.model.enums.*;
import com.application.parking.repository.*;
import com.application.parking.service.strategy.bill.BillGenerationType;
import com.application.parking.service.strategy.parkingslot.ParkingSlotAssignmentStrategyType;

import java.util.ArrayList;
import java.util.List;

public class InitService {

    private OperatorRepository operatorRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSlotRepository parkingSlotRepository;
    private GateRepository gateRepository;

    public InitService(OperatorRepository operatorRepository, ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSlotRepository parkingSlotRepository, GateRepository gateRepository) {
        this.operatorRepository = operatorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.gateRepository = gateRepository;
    }

    public ParkingLot getParkingLot(int capacity, ParkingSlotAssignmentStrategyType slotAssignmentStrategyType, BillGenerationType billGenerationType) {
        System.out.println("------------------ Parking Lot Initialization Started ------------------");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(ApplicationConstant.PARKING_LOT_NAME);
        parkingLot.setAddress(ApplicationConstant.PARKING_LOT_ADDRESS);
        parkingLot.setStatus(ParkingLotStatus.OPEN);
        parkingLot.setCapacity(capacity);
        parkingLot.setSlotAssignmentStrategy(slotAssignmentStrategyType);
        parkingLot.setBillGenerationStrategy(billGenerationType);

        //vehicle types allowed
        List<VehicleType> vehicleTypes = new ArrayList<>();
        vehicleTypes.add(VehicleType.CAR);
        vehicleTypes.add(VehicleType.TRUCK);
        vehicleTypes.add(VehicleType.BIKE);
        parkingLot.setVehicleTypes(vehicleTypes);

        //parking floor
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i=1;i<=ApplicationConstant.PARKING_FLOOR_ALLOWED;i++){
            ParkingFloor parkingFloor = createFloor(i,capacity);
            parkingFloors.add(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloors);

        parkingLotRepository.save(parkingLot);
        System.out.println("------------------ Parking Lot Initialization Completed ------------------");
        return parkingLot;
    }

    private ParkingFloor createFloor(int floorNumber, int capacity){
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setNumber(String.valueOf(floorNumber));
        parkingFloor.setStatus(ParkingFloorStatus.OPEN);
        parkingFloor.setEntryGate(createGate(floorNumber, GateType.ENTRY));
        parkingFloor.setExitGate(createGate(floorNumber, GateType.EXIT));
        int totalSlots = capacity/ApplicationConstant.PARKING_FLOOR_ALLOWED;
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        for(int i=1;i<=totalSlots;i++){
            ParkingSlot parkingSlot = createParkingSlot(floorNumber, i);
            parkingSlots.add(parkingSlot);
        }
        parkingFloor.setParkingSlots(parkingSlots);
        parkingFloorRepository.save(parkingFloor);
        return parkingFloor;
    }

    private Gate createGate(int floorNumber, GateType type){
        Gate gate = new Gate();
        String number;
        if(type.equals(GateType.ENTRY)) {
            number = floorNumber + "1";
        }else{
            number = floorNumber + "2";
        }
        gate.setNumber(number);
        gate.setType(type);
        gate.setStatus(GateStatus.OPEN);
        gate.setOperator(operatorRepository.getOperatorByEmpId(floorNumber, type));
        gateRepository.save(gate);
        return gate;
    }

    private ParkingSlot createParkingSlot(int floorNumber, int slotNumber){
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setNumber(floorNumber+""+slotNumber);
        parkingSlot.setStatus(ParkingSlotStatus.AVAILABLE);
        if(floorNumber%2==0){
            parkingSlot.setAllowedVehicleType(VehicleType.CAR);
        }else {
            parkingSlot.setAllowedVehicleType(VehicleType.BIKE);
        }
        parkingSlotRepository.save(parkingSlot);
        return parkingSlot;
    }

    public void printParkingLot() {
        displayBanner();
        System.out.println("+---------------------- Parking Lot ----------------------+");
        ParkingLot parkingLot = parkingLotRepository.findById(1);
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for (ParkingFloor parkingFloor : parkingFloors) {
            System.out.println("Floor " + parkingFloor.getNumber() + ": ");
            List<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
            // Print top border for all slots on this floor
            for (int j = 0; j < parkingSlots.size(); j++) {
                System.out.print("-----------------------");
            }
            System.out.println();

            // Print slot numbers for all slots on this floor
            for (ParkingSlot parkingSlot : parkingSlots) {
                System.out.printf("| Slot  : %-10s|   ", parkingSlot.getNumber());
            }
            System.out.println();

            for (ParkingSlot parkingSlot : parkingSlots) {
                System.out.printf("| Type  : %-10s|   ", parkingSlot.getAllowedVehicleType());
            }
            System.out.println();

            // Print slot statuses for all slots on this floor
            for (ParkingSlot parkingSlot : parkingSlots) {
                System.out.printf("| Status: %-10s|   ", parkingSlot.getStatus().toString());
            }
            System.out.println();

            // Print bottom border for all slots on this floor
            for (int j = 0; j < parkingSlots.size(); j++) {
                System.out.print("-----------------------");
            }
            System.out.println();
        }
    }

    public void displayAvailableFloor() {
        ParkingLot parkingLot = parkingLotRepository.findById(1);
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        List<ParkingFloor> carFloors = new ArrayList<>();
        List<ParkingFloor> bikeFloors = new ArrayList<>();

        for (ParkingFloor parkingFloor : parkingFloors) {
            if(parkingFloor.getParkingSlots().get(0).getAllowedVehicleType().equals(VehicleType.CAR)){
                carFloors.add(parkingFloor);
            }else if(parkingFloor.getParkingSlots().get(0).getAllowedVehicleType().equals(VehicleType.BIKE)){
                bikeFloors.add(parkingFloor);
            }
        }
        System.out.println("+---------------------- Parking Floor Board ----------------------+");
        String border = "+----------------------+----------------------+";
        String header = "|      " + VehicleType.CAR.toString() + " FLOORS      |      " + VehicleType.BIKE.toString() + " FLOORS     |";

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        // Ensure there are 5 car floors and 5 bike floors for display
        for (int i = 0; i < 5; i++) {
            String carFloorName = i < carFloors.size() ? "Floor: "+carFloors.get(i).getNumber() : "N/A";
            String carStatus = i < carFloors.size() ? getFloorStatus(carFloors.get(i)) : "N/A";

            String bikeFloorName = i < bikeFloors.size() ? "Floor: "+bikeFloors.get(i).getNumber() : "N/A";
            String bikeStatus = i < bikeFloors.size() ? getFloorStatus(bikeFloors.get(i)) : "N/A";

            System.out.printf("| %-10s: %-10s | %-10s: %-10s |\n", carFloorName, carStatus, bikeFloorName, bikeStatus);
        }

        System.out.println(border);
    }

    private String getFloorStatus(ParkingFloor parkingFloor) {
        boolean isAvailable = parkingFloor.getParkingSlots().stream()
                .anyMatch(slot -> slot.getStatus().equals(ParkingSlotStatus.AVAILABLE));
        return isAvailable ? "Available" : "Occupied";
    }

    public static void displayBanner() {
        String banner =
                "  ____             _        _        _     _     _     \n" +
                        " |  __|   _ _   __| |   ___| |_     | |   (_)___| |_   \n" +
                        " | |_    | | | / _` |  / _ \\  _|    | |   | / _ \\  _|  \n" +
                        " |  _|   | | || (_| | |  __/ |_     | |___| \\__  \\ |_  \n" +
                        " |_|     |_||_ \\__,_|  \\___| \\__|    \\_____|_|___/ \\__| \n" +
                        "                     Parking Lot System                \n";

        System.out.println(banner);
    }
}
