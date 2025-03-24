package com.java_refactoring._20_large_class._02_extract_superclass;

import java.util.List;

/**
 * refactoring smell : 클래스 하나에 필드, 메서드가 몰려 있는 경우 다른 클래스로 추출한다.
 * 긴 클래스인 경우 중복과 기능의 일부만 사용되는 등 문제가 나타나기 쉽다.
 * 다른 클래스로 필드 및 메서드를 옮길 수 있다.
 * 상속으로 여러 클래스에서 사용하는 메서드를 추상화할 수 있다.
 */
public class Department extends Party {

    private List<Employee> staff;

    public Department(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public int headCount() {
        return this.staff.size();
    }

    @Override
    public double getMonthlyCost() {
        return this.staff.stream().mapToDouble(e -> e.getMonthlyCost()).sum();
    }
}
