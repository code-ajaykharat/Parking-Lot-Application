package com.application.parking.repository;

import com.application.parking.exception.VehicleNotFoundException;
import com.application.parking.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<Integer, Vehicle> vehicleDb;

    private static int id = 0;

    public VehicleRepository() {
        vehicleDb = new HashMap<Integer, Vehicle>();
    }

    public Vehicle save(Vehicle vehicle) {
        if(vehicle!=null) {
            vehicle.setId(++id);
            vehicleDb.put(vehicle.getId(), vehicle);
            System.out.println("Vehicle saved successfully!");
            return vehicle;
        }
        throw new VehicleNotFoundException("Vehicle not found!");
    }

    public Vehicle findById(int id) {
        if (vehicleDb.containsKey(id)) {
            return vehicleDb.get(id);
        }
        throw new VehicleNotFoundException("Vehicle not found with id "+id);
    }
}
