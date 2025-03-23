package com.java_refactoring._18_middle_man._04_replace_subclass_with_delegate;

public class PermiumDelegate {
    private Booking host;
    private PremiumExtra extra;

    public PermiumDelegate(Booking host, PremiumExtra extra) {
        this.host = host;
        this.extra = extra;
    }
}
