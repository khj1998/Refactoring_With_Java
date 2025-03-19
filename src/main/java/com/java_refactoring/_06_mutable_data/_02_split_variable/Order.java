package com.java_refactoring._06_mutable_data._02_split_variable;

/**
 * refactoring smell : 결과를 담는 지역변수명 의도를 드러낼 수 있게 수정
 */
public class Order {

    public double discount(double inputValue, int quantity) {
        double result = inputValue;

        if (inputValue > 50) result -= 2;
        if (quantity > 100) result -= 1;

        return result;
    }
}
