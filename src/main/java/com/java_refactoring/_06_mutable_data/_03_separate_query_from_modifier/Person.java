package com.java_refactoring._06_mutable_data._03_separate_query_from_modifier;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
