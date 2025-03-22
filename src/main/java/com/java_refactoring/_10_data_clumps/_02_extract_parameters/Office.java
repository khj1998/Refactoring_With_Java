package com.java_refactoring._10_data_clumps._02_extract_parameters;

public class Office {

    private String location;

    private TelephoneNumber telephoneNumber;

    public Office(TelephoneNumber telephoneNumber, String officeNumber) {
        this.location = location;
        this.telephoneNumber = telephoneNumber;
    }

    public String getLocation() {
        return this.location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }

    public TelephoneNumber getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public String officePhoneNumber() {
        return this.telephoneNumber.toString();
    }
}
