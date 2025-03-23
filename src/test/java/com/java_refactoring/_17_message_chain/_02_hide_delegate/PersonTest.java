package com.java_refactoring._17_message_chain._02_hide_delegate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void manager() {
        Person keesun = new Person("keesun");
        Person nick = new Person("nick");
        keesun.setDepartment(new Department("m365deploy",nick));

        Person manager = keesun.getManager();
        assertEquals(nick,manager);
    }
}