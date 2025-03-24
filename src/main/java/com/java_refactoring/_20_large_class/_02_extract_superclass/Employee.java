package com.java_refactoring._20_large_class._02_extract_superclass;

public class Employee extends Party {

    private Integer id;

    private double monthlyCost;

    public Employee(String name,double monthlyCost) {
        super(name);
        this.monthlyCost = monthlyCost;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void updateMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public double getMonthlyCost() {
        return monthlyCost;
    }
}
