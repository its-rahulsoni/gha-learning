package com.gha.learning.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTest {

    maths math = new maths(); // Instance of the class under test

    @Test
    void testAdd() {
        assertEquals(5, math.add(2, 3));
        assertEquals(-1, math.add(-2, 1));
    }

    @Test
    void testSubtract() {
        assertEquals(1, math.subtract(4, 3));
        assertEquals(-5, math.subtract(-2, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(6, math.multiply(2, 3));
        assertEquals(0, math.multiply(0, 5));
        assertEquals(-10, math.multiply(-2, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2, math.divide(6, 3));
        assertEquals(-3, math.divide(-9, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            math.divide(10, 0);
        });
    }
}
