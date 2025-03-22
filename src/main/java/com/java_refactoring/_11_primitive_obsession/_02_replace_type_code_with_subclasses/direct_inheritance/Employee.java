package com.java_refactoring._11_primitive_obsession._02_replace_type_code_with_subclasses.direct_inheritance;

/**
 * refactoring smell : 필드의 타입이 아닌 다형성으로 구체 타입을 구분하도록 한다.
 */
public abstract class Employee {

    private String name;

    protected Employee(String name) {
        this.name = name;
    }

    public static Employee createEmployee(String name,String type) {
        switch (type) {
            case "engineer" ->  {
                return new Engineer(name);
            }
            case "manager" -> {
                return new Manager(name);
            }
            case "salesman" -> {
                return new Salesman(name);
            }
            default -> throw new IllegalArgumentException(name);
        }
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
