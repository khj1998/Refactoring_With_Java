package com.java_refactoring._08_shotgun_surgery._01_move_field;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * refactoring smell : 필드의 위치에 더 잘 맞는 클래스로 위치 이동.
 * 클래스의 역할과 어울리는 필드를 옮김으로써 응집성을 높힌다.
 */
public class Customer {

    private String name;

    private CustomerContract contract;

    public Customer(String name, double discountRate) {
        this.name = name;
        this.contract = new CustomerContract(dateToday(),discountRate);
    }

    public double getDiscountRate() {
        return this.contract.getDiscountRate();
    }

    public void updateDiscountRate(double discountRate) {
        this.contract.updateDiscountRate(discountRate);
    }

    public void becomePreferred() {
        this.updateDiscountRate(this.getDiscountRate() + 0.03);
    }

    public double applyDiscount(double amount) {
        BigDecimal value = BigDecimal.valueOf(amount);
        return value.subtract(value.multiply(BigDecimal.valueOf(this.getDiscountRate()))).doubleValue();
    }

    private LocalDate dateToday() {
        return LocalDate.now();
    }
}
