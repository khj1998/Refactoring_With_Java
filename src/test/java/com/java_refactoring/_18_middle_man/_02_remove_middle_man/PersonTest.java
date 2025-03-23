package com.java_refactoring._18_middle_man._02_remove_middle_man;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void getManager() {
        Person nick = new Person("nick",null);
        Person keesun = new Person("keesun",new Department(nick));
        assertEquals(nick,keesun.getDepartment().getManager());
    }
}