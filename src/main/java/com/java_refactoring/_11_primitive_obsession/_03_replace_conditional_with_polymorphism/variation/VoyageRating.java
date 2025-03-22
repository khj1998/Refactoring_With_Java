package com.java_refactoring._11_primitive_obsession._03_replace_conditional_with_polymorphism.variation;

import java.util.List;

/**
 * refactoring smell : 다른 조건의 변형문이 여러 메서드에서 반복되는 케이스를 클래스로 추출한다.
 * 변형이 반복된다는 사실은 조건마다 확인해야하는 도메인이 존재함을 시사하기도 한다.
 * 반복되는 조건이 특정 도메인 로직과 연결되는 경우 이를 캡슐화할 수 있다.
 */
public class VoyageRating {

    protected Voyage voyage;

    protected List<VoyageHistory> history;

    public VoyageRating(Voyage voyage, List<VoyageHistory> history) {
        this.voyage = voyage;
        this.history = history;
    }

    public char value() {
        final int vpf = this.voyageProfitFactor();
        final int vr = this.voyageRisk();
        final int chr = this.captainHistoryRisk();
        return (vpf * 3 > (vr + chr * 2)) ? 'A' : 'B';
    }

    protected int captainHistoryRisk() {
        int result = 1;
        if (this.history.size() < 5) result += 4;
        result += this.history.stream().filter(v -> v.profit() < 0).count();
        return Math.max(result, 0);
    }

    private int voyageRisk() {
        int result = 1;
        if (this.voyage.length() > 4) result += 2;
        if (this.voyage.length() > 8) result += this.voyage.length() - 8;
        if (List.of("china", "east-indies").contains(this.voyage.zone())) result += 4;
        return Math.max(result, 0);
    }

    protected int voyageProfitFactor() {
        int result = 2;
        if (this.voyage.zone().equals("china")) result += 1;
        if (this.voyage.zone().equals("east-indies")) result +=1 ;
        result += voyageLengthFactor();
        result += historyLengthFactor();

        return result;
    }

    protected int voyageLengthFactor() {
        return (this.voyage.length() > 14) ? -1 : 0;
    }

    protected int historyLengthFactor() {
        return (this.history.size() > 8) ? 1 : 0;
    }
}
