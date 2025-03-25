package com.java_refactoring._25_guard_clauses._02_after;

/**
 * refactoring smell : 특이 케이스를 먼저 조건문으로 끝내고 일반적인 경우의 조건문을 제거한다.
 * 해당 예제는 특수한 경우만 조건문으로 분기하고, 정상적인 흐름은 별도 조건 없이 수행.
 * 중첩 조건문이 발생하는 경우 코드의 가독성이 떨어질 수 있으며, 조건문이 깊으면 코드 흐름 잡기 어려워진다.
 */
public class GuardClauses {

    public int getPoints() {
        if (isVip()) return vipPoint();
        if (isPlat()) return platPoint();

        return normalPoint();
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

    private boolean isVip() {
        return false;
    }
}
