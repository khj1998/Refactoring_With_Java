package com.java_refactoring._06_mutable_data._05_replace_derived_variable_with_query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {
    @Test
    void discount() {
        Discount discount = new Discount(100);
        discount.updateDiscount(10);

        assertEquals(90,discount.getDiscountedTotal());
    }
}