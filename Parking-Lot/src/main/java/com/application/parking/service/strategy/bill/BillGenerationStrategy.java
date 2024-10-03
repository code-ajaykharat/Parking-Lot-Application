package com.application.parking.service.strategy.bill;

import com.application.parking.model.Bill;
import com.application.parking.model.Token;

public interface BillGenerationStrategy {
    Bill generate(Token token);
}
