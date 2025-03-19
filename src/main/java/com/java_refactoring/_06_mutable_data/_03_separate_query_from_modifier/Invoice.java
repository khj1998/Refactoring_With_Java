package com.java_refactoring._06_mutable_data._03_separate_query_from_modifier;

public class Invoice {

    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
