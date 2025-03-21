package com.java_refactoring._07_divergent_change._04_extract_class;

public class TelephoneNumber {
    private String areaCode;

    private String number;

    public TelephoneNumber(String areaCode,String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String telephoneNumber() {
        return this.areaCode + " " + this.number;
    }

    public String getOfficeAreaCode() {
        return areaCode;
    }

    public String getOfficeNumber() {
        return number;
    }

    public void updateOfficeAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void updateOfficeNumber(String number) {
        this.number = number;
    }
}
