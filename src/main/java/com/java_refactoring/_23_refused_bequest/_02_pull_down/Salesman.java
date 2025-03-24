package com.java_refactoring._23_refused_bequest._02_pull_down;

public class Salesman extends Employee {
    protected Quota quota;

    protected Quota getQuota() {
        return new Quota();
    }
}

