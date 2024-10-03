package com.application.parking.repository;

import com.application.parking.exception.ParkingFloorNotFoundException;
import com.application.parking.model.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorDb;

    private static int id;

    public ParkingFloorRepository() {
        parkingFloorDb = new HashMap<Integer, ParkingFloor>();
    }

    public ParkingFloor save(ParkingFloor parkingFloor) {
        if(parkingFloor!=null){
            parkingFloor.setId(++id);
            parkingFloorDb.put(parkingFloor.getId(), parkingFloor);
            System.out.println("Parking floor saved successfully!");
            return parkingFloor;
        }
        throw new ParkingFloorNotFoundException("Parking floor not found");
    }

    public ParkingFloor findById(int id) {
        if(parkingFloorDb.containsKey(id)){
            return parkingFloorDb.get(id);
        }
        throw new ParkingFloorNotFoundException("Parking floor not found with id "+id);
    }
}
