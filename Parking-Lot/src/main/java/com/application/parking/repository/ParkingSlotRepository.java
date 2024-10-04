package com.application.parking.repository;

import com.application.parking.exception.ParkingSlotNotFoundException;
import com.application.parking.model.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSlotRepository {
    private Map<Integer, ParkingSlot> parkingSlotDb;

    private static int id = 0;

    public ParkingSlotRepository() {
        parkingSlotDb = new HashMap<Integer, ParkingSlot>();
    }

    public ParkingSlot save(ParkingSlot parkingSlot) {
        if(parkingSlot!=null){
            if(!parkingSlotDb.containsKey(parkingSlot.getId())){
                parkingSlot.setId(++id);
            }
            parkingSlotDb.put(parkingSlot.getId(), parkingSlot);
            //System.out.println("Parking slot saved successfully!");
            return parkingSlot;
        }
        throw new ParkingSlotNotFoundException("Parking slot not found!");
    }

    public ParkingSlot findById(int id) {
        if(parkingSlotDb.containsKey(id)){
            return parkingSlotDb.get(id);
        }
        throw new ParkingSlotNotFoundException("Parking slot not found with id "+ id);
    }
}
