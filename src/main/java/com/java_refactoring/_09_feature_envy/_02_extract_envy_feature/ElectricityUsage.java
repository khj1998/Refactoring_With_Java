package com.java_refactoring._09_feature_envy._02_extract_envy_feature;

public class ElectricityUsage {

    private double amount;

    private double pricePerUnit;

    public ElectricityUsage(double amount, double pricePerUnit) {
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
    }

    public double getAmount() {
        return amount;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getElecticityBill() {
        return this.getAmount() * this.getPricePerUnit();
    }
}
