package com.application.parking.controller;

import com.application.parking.dto.request.BillRequest;
import com.application.parking.dto.response.BillResponse;
import com.application.parking.model.Bill;
import com.application.parking.service.BillService;

public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public BillResponse generateBill(BillRequest billRequest) {
        BillResponse billResponse = new BillResponse();
        try{
            Bill bill = billService.generateBill(billRequest.getTokenId());
            double amount = bill.getAmount();
            billResponse.setAmount(amount);
            billResponse.setMessage("Bill generated successfully");
        }catch(Exception e){
            billResponse.setMessage("Error generating bill: " + e.getMessage());
        }
        return billResponse;
    }
}
