package com.java_refactoring._18_middle_man._02_remove_middle_man;

/**
 * refactoring smell : Person에서 Department를 조회할 수 있도록 한다. (캡슐화를 깬다.)
 * 지나친 캡슐화가 도리어 의미를 드러내지 못하는 경우
 * 캡슐화를 깨고 드러낸 객체를 접근해 개발하는 것이 더 효율적인 경우 생각해 볼 수 있다.
 */
public class Person {

    private Department department;

    private String name;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Department getDepartment() {
        return this.department;
    }
}
