package org.example;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;


class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        System.out.println("sgsdfgds");
        assertEquals(5.0, calculator.add(2, 3), 0.001);
        assertEquals(-1.0, calculator.add(-2, 1), 0.001);
        assertEquals(0.0, calculator.add(0, 0), 0.001);
    }

    @Test
    void testSubtraction() {
        assertEquals(1.0, calculator.subtract(3, 2), 0.001);
        assertEquals(-3.0, calculator.subtract(-2, 1), 0.001);
        assertEquals(0.0, calculator.subtract(0, 0), 0.001);
    }

    @Test
    void testMultiplication() {
        assertEquals(6.0, calculator.multiply(2, 3), 0.001);
        assertEquals(-2.0, calculator.multiply(-1, 2), 0.001);
        assertEquals(0.0, calculator.multiply(0, 10), 0.001);
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calculator.divide(6, 3), 0.001);
        assertEquals(-2.5, calculator.divide(-5, 2), 0.001);
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}
