package com.application.parking.service.strategy.bill;

import java.util.Objects;

public class BillGenerationStrategyFactory {
    public static BillGenerationStrategy getBillGenerationStrategy(BillGenerationType type){
        if (type.equals(BillGenerationType.SIMPLE)) {
            return new SimpleBillGenerationStrategy();
        }
        return null;
    }
}
