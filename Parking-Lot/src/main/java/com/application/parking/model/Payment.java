package com.application.parking.model;

import com.application.parking.model.enums.PaymentMode;
import com.application.parking.model.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseModel{
    private double amount;
    private PaymentMode mode;
    private PaymentStatus status;
    private String payRefNumber;
    private LocalDateTime time;

    public Payment(){}
    public Payment(double amount, PaymentMode mode, PaymentStatus status, String payRefNumber, LocalDateTime time) {
        this.amount = amount;
        this.mode = mode;
        this.status = status;
        this.payRefNumber = payRefNumber;
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getPayRefNumber() {
        return payRefNumber;
    }

    public void setPayRefNumber(String payRefNumber) {
        this.payRefNumber = payRefNumber;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
