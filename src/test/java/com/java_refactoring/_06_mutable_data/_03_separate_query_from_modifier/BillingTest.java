package com.java_refactoring._06_mutable_data._03_separate_query_from_modifier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BillingTest {

    @Test
    void getTotalOutstandingAndSendBill() {
        Billing billing = new Billing(new Customer("keesun", List.of(new Invoice(20),new Invoice(30))),
                new EmailGateway());
        assertEquals(50d,billing.totalOutstanding());

        billing.sendBill();
    }
}