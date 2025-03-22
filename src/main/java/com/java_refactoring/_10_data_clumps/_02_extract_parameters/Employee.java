package com.java_refactoring._10_data_clumps._02_extract_parameters;

public class Employee {

    private String name;

    private TelephoneNumber telephoneNumber;

    public Employee(String name, TelephoneNumber telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public String personalPhoneNumber() {
        return this.telephoneNumber.toString();
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public TelephoneNumber getTelephoneNumber() {
        return this.telephoneNumber;
    }
}
