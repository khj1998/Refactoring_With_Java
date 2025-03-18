package com.java_refactoring._04_long_parameter_list._02_replcate_parameter_with_query;

/**
 * refactoring smell : 불필요한 함수 파라미터 (discountLevel) 제거
 * Order 클래스의 필드의 quantity 값을 통해 discountLevel을 결정하는 메서드로 추출할 수 있다.
 * 함수 호출부에서 discountLevel을 결정하는 책임을 지지않고, 메서드 내부에서 책임을 진다.
 */
public class Order {

    private int quantity;

    private double itemPrice;

    public Order(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double finalPrice() {
        double basePrice = this.quantity * this.itemPrice;
        return this.discountedPrice(basePrice);
    }

    private int getDiscountLevel() {
        return this.quantity > 100 ? 2 : 1;
    }

    private double discountedPrice(double basePrice) {
        return getDiscountLevel() == 2 ? basePrice * 0.9 : basePrice * 0.95;
    }
}
