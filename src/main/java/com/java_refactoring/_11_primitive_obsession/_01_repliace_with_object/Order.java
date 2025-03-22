package com.java_refactoring._11_primitive_obsession._01_repliace_with_object;

/**
 * refactoring smell : 이전에 선언된 필드 타입으로 표현하기 어려운 경우 클래스 객체로 표현한다.
 * 기존 요구사항에서 필드 타입에 따른 비즈니스 로직, 검증 로직 등이 추가되어야 하는 경우 유용하다.
 */
public class Order {

    private Priority priority;

    public Order(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return this.priority;
    }
}
