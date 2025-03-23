package com.java_refactoring._17_message_chain._02_hide_delegate;

/**
 * refactoring smell : 클라이언트에서 많은 위임 관련 정보를 모르게, 위임을 숨긴다. (getManager)
 * 클라이언트에서 너무 많은 위임 (메서드 체이닝)을 알아야 한다면, 중간 메서드에서 변경 발생시 호출하는 부분에도 영향이 가게 된다.
 * 캡슐화 적용. 메서드 호출을 숨기는 것 또한 다른 모듈의 정보를 최소한으로 알게 돕는다.
 */
public class Person {

    private String name;

    private Department department;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person getManager() {
        return this.department.getManager();
    }
}
