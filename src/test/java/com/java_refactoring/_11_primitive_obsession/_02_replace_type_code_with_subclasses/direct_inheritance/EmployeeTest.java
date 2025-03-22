package com.java_refactoring._11_primitive_obsession._02_replace_type_code_with_subclasses.direct_inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void createEmployee() {
        assertEquals("engineer",Employee.createEmployee("hojin","engineer").getType());
        assertEquals("manager",Employee.createEmployee("hojin","manager").getType());
        assertThrows(IllegalArgumentException.class,() -> Employee.createEmployee("hojin","wrong type"));
    }
}