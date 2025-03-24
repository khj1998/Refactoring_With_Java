package com.java_refactoring._20_large_class._02_extract_superclass;

public abstract class Party {
    protected String name;

    public Party(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract double getMonthlyCost();

    public double getAnnualCost() {
        return this.getMonthlyCost() * 12;
    }
}
