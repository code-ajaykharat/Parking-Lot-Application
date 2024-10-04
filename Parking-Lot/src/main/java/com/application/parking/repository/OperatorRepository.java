package com.application.parking.repository;

import com.application.parking.constant.ApplicationConstant;
import com.application.parking.exception.OperatorNotFoundException;
import com.application.parking.model.Operator;
import com.application.parking.model.enums.GateType;

import java.util.HashMap;
import java.util.Map;

public class OperatorRepository {
    private Map<Integer, Operator> operatorDb;

    private static int id = 0;

    public OperatorRepository() {
        operatorDb = new HashMap<Integer, Operator>();
        int id = 0;
        for(int i = 1;i <= ApplicationConstant.PARKING_FLOOR_ALLOWED;i++){
            Operator operator1 = new Operator();
            operator1.setId(++id);
            operator1.setName("Operator: " + id);
            operator1.setEmpId(i +""+ 1);
            operatorDb.put(operator1.getId(), operator1);

            Operator operator2 = new Operator();
            operator2.setId(++id);
            operator2.setName("Operator: " + id);
            operator2.setEmpId(i +""+ 2);
            operatorDb.put(operator2.getId(), operator2);
        }
    }

    public Operator getOperatorByEmpId(int floor, GateType gateType) {
        int gate;
        if(gateType.equals(GateType.ENTRY)){
            gate = 1;
        }else{
            gate = 2;
        }
        String empId = floor +""+ gate;
        for (Operator operator : operatorDb.values()) {
            if(operator.getEmpId().equals(empId)){
                return operator;
            }
        }
        throw new OperatorNotFoundException("Operator not found with empId " + empId);
    }
}
