package com.sfeir.quarterbacks.records;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.*;

public class MerchantOperations {

    public List<Merchant> findTopMerchants(List<Merchant> merchants, int month) {

        // Local record
        record MerchantSales(Merchant merchant, double sales){}

        return merchants.stream()
                .map(merchant -> new MerchantSales(merchant, computeSales(merchant, month)))
                .sorted(Comparator.comparingDouble(MerchantSales::sales))
                .map(MerchantSales::merchant)
                .collect(toList());
    }

    private double computeSales(Merchant merchant, int month){
        // Some business logic to get sales
        return ThreadLocalRandom.current().nextDouble(100, 10000);
    }
}
