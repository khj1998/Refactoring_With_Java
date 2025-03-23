package com.java_refactoring._16_temporary_field._02_introduce_special_case;

public class UnknownCustomer extends Customer {
    public UnknownCustomer() {
        super("unknown",null,new NullPaymentHistory());
    }

    @Override
    public boolean isUnknown() {
        return true;
    }

    @Override
    public String getName() {
        return "occupant";
    }

    @Override
    public BillingPlan getBillingPlan() {
        return new BasicBillingPlan();
    }
}
