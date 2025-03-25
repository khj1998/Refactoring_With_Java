package com.java_refactoring._25_guard_clauses._01_before;

public class GuardClauses {

    public int getPoints() {
        int result;
        if (ivVip()) {
            result = vipPoint();
        } else if (isPlat()) {
            result = platPoint();
        } else {
            result = normalPoint();
        }

        return result;
    }

    private int normalPoint() {
        return 0;
    }

    private int platPoint() {
        return 1;
    }

    private boolean isPlat() {
        return false;
    }

    private int vipPoint() {
        return 1;
    }

    private boolean ivVip() {
        return false;
    }
}
