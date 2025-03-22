package com.java_refactoring._09_feature_envy._02_extract_envy_feature;

/**
 * refactoring smell : 한 클래스에서 다른 클래스 변수를 지나치게 많이 참조하는 경우 기능을 옮긴다.
 * 다른 객체의 getter를 여러개 사용하고 있다면, 다른 모듈이 이행 가능한 기능까지 수행함을 의심할 만 하다.
 */
public class Bill {

    private ElectricityUsage electricityUsage;

    private GasUsage gasUsage;

    public double calculateBill() {
        return electricityUsage.getElecticityBill() + gasUsage.getGasBill();
    }
}
