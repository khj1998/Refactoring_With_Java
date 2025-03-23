package com.java_refactoring._18_middle_man._03_replace_superclass_with_delegate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * refactoring smell : 상속 클래스를 위임으로 수정한다.
 * 이펙티브 자바 서적에서는 상속 대신 컴포지션을 사용하라 라는 구절에서 소개되는 방법.
 * 슈퍼 클래스의 변경점의 범위를 가늠하기 어려운 경우
 * 상위 클래스의 기능을 모두 알고 있는 것이 적절하지 않은 경우 (ex - Stack 클래스의 Vector 클래스 상속)
 * 이러한 경우들에 상속대신 위임으로 고려해 볼 수 있다.
 */
public class Scroll {

    private LocalDate dateLastCleaned;
    private CategoryItem categoryItem;

    public Scroll(Integer id, String title, List<String> tags, LocalDate dateLastCleaned) {
        this.dateLastCleaned = dateLastCleaned;
        this.categoryItem = new CategoryItem(id,title,tags);
    }

    public long daysSinceLastCleaning(LocalDate targetDate) {
        return this.dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
    }
}
