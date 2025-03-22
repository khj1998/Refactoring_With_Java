package com.java_refactoring._11_primitive_obsession._03_replace_type_code_with_subclasses.indirect_inheritance;

/**
 * refactoring smell : 직접 상속이 어려운 경우 필드를 클래스로 추출해 구분한다.
 */
public class Employee {

    private String name;

    private EmployeeType employeeType;

    public Employee(String name,String typeValue) {
        this.name = name;
        this.employeeType = this.getEmployeeType(typeValue);
    }

    public String capitalizedType() {
        return this.employeeType.capitalizedType();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    private EmployeeType getEmployeeType(String type) {
        return switch (type) {
            case "engineer" -> new Engineer();
            case "manager" -> new Manager();
            case "salesman" -> new Salesman();
            default -> throw new IllegalArgumentException(type);
        };
    }
}
