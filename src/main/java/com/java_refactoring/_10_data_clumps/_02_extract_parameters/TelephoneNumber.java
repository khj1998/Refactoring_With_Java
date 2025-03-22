package com.java_refactoring._10_data_clumps._02_extract_parameters;

public class TelephoneNumber {
    private String phoneNumber;
    private String areaCode;

    public TelephoneNumber(String phoneNumber, String areaCode) {
        this.phoneNumber = phoneNumber;
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return areaCode + "-" + phoneNumber;
    }
}
