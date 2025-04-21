package com.application.parking.service;

import com.application.parking.dto.response.BillResponse;
import com.application.parking.model.Bill;
import com.application.parking.model.Token;
import com.application.parking.model.enums.BillStatus;
import com.application.parking.repository.BillRepository;
import com.application.parking.repository.TokenRepository;
import com.application.parking.service.strategy.bill.BillGenerationStrategy;

import java.time.LocalDateTime;

public class BillService {

    // This class is responsible for generating the bill for a parking slot.
    // It will use the BillGenerationStrategy to calculate the bill based on the parking duration and rate.

     private BillGenerationStrategy billGenerationStrategy;
     private TokenRepository ticketRepository;
     private BillRepository billRepository;

     public BillService(BillGenerationStrategy billGenerationStrategy, TokenRepository ticketRepository, BillRepository billRepository) {
         this.billGenerationStrategy = billGenerationStrategy;
         this.ticketRepository = ticketRepository;
         this.billRepository = billRepository;
     }

     public Bill generateBill(int tokenId) {
         // Fetch the token from the repository
         Token token = ticketRepository.findById(tokenId);
         // Calculate the parking duration
         int hours = LocalDateTime.now().getHour() - token.getEntryTime().getHour();
         double amount = billGenerationStrategy.generatePrice(hours, token.getVehicle().getType());
         // Create a new bill object
         Bill bill = new Bill();
         bill.setAmount(amount);
         bill.setStatus(BillStatus.UNPAID);
         bill.setToken(token);
         bill.setExitTime(LocalDateTime.now());
         bill.setExitGate(null);
         // Save the bill to the repository
         billRepository.save(bill);
         return bill;
     }
}
