package com.java_refactoring._18_middle_man._01_before;

import java.util.List;

public class Show {

    private List<String> properties;

    private double price;

    public Show(List<String> properties, double price) {
        this.properties = properties;
        this.price = price;
    }

    public boolean hasOwnProperty(String property) {
        return this.properties.contains(property);
    }

    public double getPrice() {
        return price;
    }
}
