
package com.java_refactoring._15_speculative_generality._02_remove_dead_code;

import java.time.LocalDateTime;

/**
 * refactoring smell : 사용하지 않는 코드를 제거하라. 혹은 미리 개발하지 말라. (You arent gonna need it)
 * 이 장에서는 굳이 삭제하지는 않았다.
 * 사용하지 않는 기능을 추측해서 개발한 경우 기능을 파악해야할 개발자 입장에서 난처......
 */
public class Reservation {

    private String title;

    private LocalDateTime from;

    private LocalDateTime to;

    private LocalDateTime alarm;

    public Reservation(String title, LocalDateTime from, LocalDateTime to) {
        this.title = title;
        this.from = from;
        this.to = to;
    }

    public void setAlarmBefore(int minutes) {
        this.alarm = this.from.minusMinutes(minutes);
    }

    public LocalDateTime getAlarm() {
        return alarm;
    }
}
