package com.application.parking.model;

import com.application.parking.model.enums.BillStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Bill extends BaseModel{
    private double amount;
    private List<Payment> payments;
    private Token token;
    private Gate exitGate;
    private BillStatus status;
    private LocalDateTime exitTime;
    public Bill(){}

    public Bill(double amount, List<Payment> payments, Token token, Gate exitGate, BillStatus status, LocalDateTime exitTime) {
        this.amount = amount;
        this.payments = payments;
        this.token = token;
        this.exitGate = exitGate;
        this.status = status;
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
