package com.application.parking.repository;

import com.application.parking.exception.BillNotFoundException;
import com.application.parking.model.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {
    private Map<Integer, Bill> billsDb;

    private static int id = 0;

    public BillRepository() {
        this.billsDb = new HashMap<Integer, Bill>();
    }

    public Bill save(Bill bill) {
        if(bill != null) {
            bill.setId(++id);
            this.billsDb.put(bill.getId(), bill);
            System.out.println("Bill saved successfully!");
            return bill;
        }
        throw new BillNotFoundException("Bill not found");
    }

    public Bill findById(int id) {
        if(this.billsDb.containsKey(id)) {
            return this.billsDb.get(id);
        }
        throw new BillNotFoundException("Bill not found with id " + id);
    }
}
