package com.java_refactoring._06_mutable_data._03_separate_query_from_modifier;

import java.util.List;

/**
 * refactoring smell : 하나의 함수에서 조회와 변경을 함께하는 부분을 두 함수로 나눈다. (명령형, 쿼리형 함수)
 */
public class Criminal {

    public void alertForMiscreant(List<Person> people) {
        if (!findMiscreant(people).isBlank()) {
            setOffAlarms();
        }
    }

    public String findMiscreant(List<Person> people) {
        for (Person p : people) {
            if (p.getName().equals("Don")) {
                return "Don";
            }

            if (p.getName().equals("John")) {
                return "John";
            }
        }

        return "";
    }

    private void setOffAlarms() {
        System.out.println("set off alarm");
    }
}
