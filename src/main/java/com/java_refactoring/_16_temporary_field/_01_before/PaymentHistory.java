package com.java_refactoring._16_temporary_field._01_before;

public class PaymentHistory {

    private int weeksDelinquentInLastYear;

    public PaymentHistory(int weeksDelinquentInLastYear) {
        this.weeksDelinquentInLastYear = weeksDelinquentInLastYear;
    }

    public int getWeeksDelinquentInLastYear() {
        return this.weeksDelinquentInLastYear;
    }
}
