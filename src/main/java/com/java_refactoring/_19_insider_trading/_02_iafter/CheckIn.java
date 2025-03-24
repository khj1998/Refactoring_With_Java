package com.java_refactoring._19_insider_trading._02_iafter;

import java.time.LocalDate;

/**
 * refactoring smell : 관련된 모듈의 내부 정보를 너무 많이 알고 있는 경우 - 함수 or 필드 옮기기
 * 결합된 다른 모듈의 내부 정보를 너무 많이 알아야 하는 경우, 해당 메서드는 다른 모듈에 있는 것이 적절하다.
 * 혹은 위임으로 클래스간 연결을 중재해 줄 수 있다.
 */
public class CheckIn {
    private  final Ticket ticket;

    public CheckIn(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
