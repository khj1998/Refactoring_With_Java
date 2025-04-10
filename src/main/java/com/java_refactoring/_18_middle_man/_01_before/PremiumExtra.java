package com.java_refactoring._18_middle_man._01_before;

import java.util.List;

public class PremiumExtra {

    private List<String> properties;

    private double premiumFee;

    public PremiumExtra(List<String> properties, double premiumFee) {
        this.properties = properties;
        this.premiumFee = premiumFee;
    }

    public double getPremiumFee() {
        return premiumFee;
    }

    public boolean hasOwnProperty(String property) {
        return this.properties.contains(property);
    }
}
