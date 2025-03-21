package com.java_refactoring._07_divergent_change._02_split_phase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceOrderTest {
    @Test
    void discountedFee() {
        PriceOrder priceOrder = new PriceOrder();

        double price = priceOrder.priceOrder(new Product(10,2,0.5),4
        ,new ShippingMethod(20,1,5));

        assertEquals(34,price);
    }

    @Test
    void feePerCase() {
        PriceOrder priceOrder = new PriceOrder();

        double price = priceOrder.priceOrder(new Product(10,2,0.5),2,
                new ShippingMethod(20,1,5));

        assertEquals(30,price);
    }
}