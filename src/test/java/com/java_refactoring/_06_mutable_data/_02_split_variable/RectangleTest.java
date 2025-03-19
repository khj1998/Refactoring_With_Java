package com.java_refactoring._06_mutable_data._02_split_variable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {
    @Test
    void updateGeometry() {
        Rectangle rectangle = new Rectangle();
        rectangle.updateGeometry(10,5);
        assertEquals(50d,rectangle.getArea());
        assertEquals(30d,rectangle.getPerimeter());
    }
}