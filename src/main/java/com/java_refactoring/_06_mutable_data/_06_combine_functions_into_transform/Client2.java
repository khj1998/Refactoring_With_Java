package com.java_refactoring._06_mutable_data._06_combine_functions_into_transform;

public class Client2 extends ReadingClient {

    private double base;
    private double taxableCharge;

    public Client2(Reading reading) {
        this.base = enrichReading(reading).baseCharge();
        this.taxableCharge = Math.max(0, this.base - taxThreshold(reading.year()));
    }

    public double getBase() {
        return base;
    }

    public double getTaxableCharge() {
        return taxableCharge;
    }
}
