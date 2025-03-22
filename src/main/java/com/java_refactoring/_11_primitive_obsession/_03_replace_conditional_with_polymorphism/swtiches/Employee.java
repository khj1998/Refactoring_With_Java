package com.java_refactoring._11_primitive_obsession._03_replace_conditional_with_polymorphism.swtiches;

import java.util.List;

/**
 * refactoring factor : 조건문을 다형성으로 수정.
 * 공통적으로 쓰임이 있는 메서드는 기본 구현형태를 제공.
 * 어떤 타입의 Employee냐에 따라 필요한 함수 구현체들이 각기 다르다. => 추상 함수로 제공
 */
public abstract class Employee {
    protected List<String> availableProjects;

    public Employee(List<String> availableProjects) {
        this.availableProjects = availableProjects;
    }

    public Employee() {}

    public abstract int vacationHours();

    public boolean canAccessTo(String project) {
        return this.availableProjects.contains(project);
    }
}
