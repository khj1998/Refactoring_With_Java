package com.java_refactoring._07_divergent_change._03_move_function;

/**
 * refactoring smell : 특정 기능을 하는 함수를 역할에 맞는 클래스로 위치를 옮긴다.
 * 본 강의에서 overdraftCharge 메서드는 AccountType에 종속성을 가지므로 메서드를 AccountType으로 옮겼다.
 * 본인도 Account의 daysOverdrawn 필드를 넘겨주고, return 값은 AccountType에 의존한다고 판단된다.
 */
public class Account {

    private int daysOverdrawn;

    private AccountType type;

    public Account(int daysOverdrawn, AccountType type) {
        this.daysOverdrawn = daysOverdrawn;
        this.type = type;
    }

    public double getBankCharge() {
        double result = 4.5;
        if (this.daysOverdrawn() > 0) {
            result += this.type.overdraftCharge(daysOverdrawn);
        }
        return result;
    }

    private int daysOverdrawn() {
        return this.daysOverdrawn;
    }
}
