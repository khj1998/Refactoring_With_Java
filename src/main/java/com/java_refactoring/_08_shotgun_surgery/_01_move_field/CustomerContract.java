package com.java_refactoring._08_shotgun_surgery._01_move_field;

import java.time.LocalDate;

public class CustomerContract {

    private LocalDate startDate;

    private double discountRate;

    public CustomerContract(LocalDate startDate,double discountRate) {
        this.startDate = startDate;
        this.discountRate = discountRate;
    }

    protected LocalDate getStartDate() {
        return this.startDate;
    }

    protected double getDiscountRate() {
        return this.discountRate;
    }

    protected void updateStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    protected void updateDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
