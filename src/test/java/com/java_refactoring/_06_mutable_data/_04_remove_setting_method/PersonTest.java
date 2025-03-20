package com.java_refactoring._06_mutable_data._04_remove_setting_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void person() {
        Person person = new Person();

        person.initializeId(10);
        person.updateName("keesun");
        assertEquals(10,person.getId());
        assertEquals("keesun",person.getName());

        person.updateName("whiteship");
        assertEquals("whiteship",person.getName());
    }
}