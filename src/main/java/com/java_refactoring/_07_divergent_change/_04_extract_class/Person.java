package com.java_refactoring._07_divergent_change._04_extract_class;

/**
 * refactoring smell : 연관된 데이터를 하나의 클래스로 추출해낸다.
 * 자주 함께 변경되고 조회되는 데이터는 별도의 클래스로 추출할 것을 고려해 볼 만하다.
 */
public class Person {

    private String name;

    private TelephoneNumber telephoneNumber;

    public String name() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public TelephoneNumber getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public void initializeTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
