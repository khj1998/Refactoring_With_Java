package com.java_refactoring._05_global_data._02_encapsulate_variable;

/**
 * refactoring smell : 전역변수로 참조될 수 있는 클래스 필드 접근을 캡슐화함. (getter, setter)
 * 무분별한 전역변수 남발시 모든 클래스에서 접근이 가능하여 사용 및 변경 범위 예측이 어려워진다.
 */
public class Home {

    public static void main(String[] args) {
        System.out.println(Thermostats.getTargetTemperature());
        Thermostats.setTargetTemperature(100);
        Thermostats.setFahrenheit(false);
    }
}
