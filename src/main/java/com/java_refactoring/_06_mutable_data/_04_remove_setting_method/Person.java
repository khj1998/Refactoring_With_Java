package com.java_refactoring._06_mutable_data._04_remove_setting_method;

/**
 * refactoring smell : setter 함수를 제거한다.
 * 본 강의에서 조금 다르게 수정하였다. setter 함수 대신 필드 변경의 의도를 드러내는 네이밍의 함수로 수정한다.
 */
public class Person {

    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void initializeId(int id) {
        this.id = id;
    }
}
