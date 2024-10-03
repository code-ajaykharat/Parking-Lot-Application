package com.application.parking.repository;

import com.application.parking.exception.ParkingLotNotFoundException;
import com.application.parking.model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotDb;

    private static int id=0;

    public ParkingLotRepository() {
        parkingLotDb = new HashMap<Integer, ParkingLot>();
    }

    public ParkingLot save(ParkingLot parkingLot) {
        if(parkingLot!=null){
            parkingLot.setId(++id);
            parkingLotDb.put(parkingLot.getId(), parkingLot);
            System.out.println("Parking lot saved successfully!");
            return parkingLot;
        }
        throw new ParkingLotNotFoundException("Parking lot not found!");
    }

    public ParkingLot findById(int id) {
        if(parkingLotDb.containsKey(id)){
            return parkingLotDb.get(id);
        }
        throw new ParkingLotNotFoundException("Parking lot not found with id "+id);
    }
}
