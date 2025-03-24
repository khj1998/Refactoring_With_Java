package com.java_refactoring._22_data_class._02_encapsulate_record;

/**
 * refactoring smell : public으로 선언된 필드들을 캡슐화한다.
 * 해당 예제는 getter, setter를 선언.
 * 혹은 Organization 객체를 불변 객체로 선언하는 방법도 있다. (record)
 */
public class Organization {

    private String name;

    private String country;

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateCountry(String country) {
        this.country = country;
    }
}
