package com.java_refactoring._06_mutable_data._07_change_reference_to_value;

import java.util.Objects;

/**
 * refactoring smell : 기존의 변경 가능한 VO 구조에서 불변한 VO 구조로 수정
 * setter 제거
 * 생성자로부터만 필드를 초기화 할 수 있도록 수정
 * JAVA 14 버전 이후 record로 손쉽게 불변 객체 생성 가능
 */
public final class TelephoneNumber {

    private final String areaCode;

    private final String number;

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String areaCode() {
        return areaCode;
    }

    public String number() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TelephoneNumber that = (TelephoneNumber) obj;
        return Objects.equals(areaCode,that.areaCode) && Objects.equals(number,that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }
}
