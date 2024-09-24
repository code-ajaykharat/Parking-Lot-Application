package com.application.parking.model;

import com.application.parking.model.enums.GateStatus;
import com.application.parking.model.enums.GateType;

public class Gate extends BaseModel{
    private String number;
    private GateType type;
    private GateStatus status;
    private Operator operator;

    public Gate(){}

    public Gate(String number, GateType type, GateStatus status, Operator operator) {
        this.number = number;
        this.type = type;
        this.status = status;
        this.operator = operator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
