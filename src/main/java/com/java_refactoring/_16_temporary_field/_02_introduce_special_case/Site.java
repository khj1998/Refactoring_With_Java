package com.java_refactoring._16_temporary_field._02_introduce_special_case;

public class Site {

    private Customer customer;

    public Site(Customer customer) {
        this.customer = customer.isUnknown() ? new UnknownCustomer() : customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
