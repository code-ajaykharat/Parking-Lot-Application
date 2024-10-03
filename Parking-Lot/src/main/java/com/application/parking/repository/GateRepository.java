package com.application.parking.repository;

import com.application.parking.exception.GateNotFoundException;
import com.application.parking.model.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Integer, Gate> gateDb;

    private static int id = 0;

    public GateRepository() {
        this.gateDb = new HashMap<Integer, Gate>();
    }

    public Gate save(Gate gate) {
        if (gate != null) {
            gate.setId(++id);
            this.gateDb.put(gate.getId(), gate);
            System.out.println("Gate saved successfully!");
            return gate;
        }
        throw new GateNotFoundException("Gate not found");
    }

    public Gate findById(int id) {
        if (this.gateDb.containsKey(id)) {
            return this.gateDb.get(id);
        }
        throw new GateNotFoundException("Gate not found with id " + id);
    }
}
