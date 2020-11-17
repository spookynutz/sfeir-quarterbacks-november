package com.sfeir.quarterbacks.records;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MerchantOperationsTest {

    public static final Merchant BOBBY = new Merchant("Bobby");
    public static final Merchant TOMMY = new Merchant("Tommy");
    public static final Merchant JOHNNY = new Merchant("Johnny");

    @Test
    void should_retrieve_merchants_ordered_by_their_sales(){
        final List<Merchant> merchants = List.of(
                BOBBY,
                TOMMY,
                JOHNNY
        );

        final List<Merchant> actual = new MerchantOperations().findTopMerchants(merchants, Calendar.DECEMBER);

        assertThat(actual).containsExactlyInAnyOrder(BOBBY, TOMMY, JOHNNY);
    }
}