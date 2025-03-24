package com.java_refactoring._24_comments._02_introduce_assertion;

/**
 * refactoring smell : 반드시 참이여야 하는 조건에 assert 문을 작성한다.
 * 자바는 기본적으로 런타임에서 assert 문은 검사하지 않는다.
 * 명시적으로 프로그래머들끼리 의사소통하기 위한 수단.
 * 개인적으로 클라이언트 레벨에서 어떤 예외인지 알아야하는 경우가 있다. 따라서 assert 보다 커스텀 예외를 응답하는게 생각한다.
 * 혹은 assert 문 보다 검증 로직을 메서드 네이밍으로 의도를 드러내 명시적으로 작성하는 것이 좋다고 생각함.
 */
public class Customer {

    private Double discountRate;

    public double applyDiscount(double amount) {
        return (this.discountRate != null) ? amount - (this.discountRate * amount) : amount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        assert discountRate != null && discountRate > 0;
        this.discountRate = discountRate;
    }
}
