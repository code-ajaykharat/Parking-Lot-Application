package com.application.parking.dto.response;

public class BillResponse {
    private double amount;
    private String message;
    public BillResponse() {
    }
    public BillResponse(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
