package com.java_refactoring._11_primitive_obsession._02_replace_type_code_with_subclasses.indirect_inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

    @Test
    void createEmployee() {
        assertEquals("Manager", new FullTimeEmployee("hojin","manager").capitalizedType());
        assertEquals("Engineer", new PartTimeEmployee("hojin","engineer").capitalizedType());
        assertThrows(IllegalArgumentException.class,() -> new Employee("hojin","wrong type"));
    }
}