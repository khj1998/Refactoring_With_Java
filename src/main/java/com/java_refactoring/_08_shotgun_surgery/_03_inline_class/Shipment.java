package com.java_refactoring._08_shotgun_surgery._03_inline_class;

/**
 * refactoring smell : 클래스 인라인
 * 클래스 추출하기와 반대의 방식.
 * 클래스의 책임을 여러 클래스로 옮기다 보면, 클래스의 존재 이유가 빈약해지는 경우가 발생할 수 있다. (지나친 기능 분산으로 응집성 약화)
 */
public class Shipment {

    private String shippingCompany;

    private String trackingNumber;

    public Shipment(String shippingCompany,String trackingNumber) {
        this.shippingCompany = shippingCompany;
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingInfo() {
        return this.shippingCompany + ": " + this.trackingNumber;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
