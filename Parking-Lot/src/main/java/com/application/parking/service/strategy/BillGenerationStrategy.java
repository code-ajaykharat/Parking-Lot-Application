package com.application.parking.service.strategy;

import com.application.parking.model.Bill;
import com.application.parking.model.Token;

public interface BillGenerationStrategy {
    Bill generate(Token token);
}
