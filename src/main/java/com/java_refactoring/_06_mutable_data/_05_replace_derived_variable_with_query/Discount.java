package com.java_refactoring._06_mutable_data._05_replace_derived_variable_with_query;

/**
 * refactoring smell : 다른 변수(필드)로부터 파생될 수 있응 변수(or 필드)는 제거할 수 있다.
 */
public class Discount {
    private double discount;

    private double baseTotal;

    public Discount(double baseTotal) {
        this.baseTotal = baseTotal;
    }

    public double getDiscountedTotal() {
        return this.baseTotal - this.discount;
    }

    public void updateDiscount(double number) {
       this.discount = number;
    }
}
