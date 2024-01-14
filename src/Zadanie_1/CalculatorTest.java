package Zadanie_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void init() {
        calculator = new Calculator();
    }
    @Test
    @DisplayName("Multiplication of calculator")
    void testMultiply() {
        assertEquals(10, calculator.multiply(2, 5),
                "Multiplication should work");
    }
    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by zero")
    void testMultiplicationByZero() {
        assertEquals(0, calculator.multiply(0, 10),
                "Multiplication by zero should be zero");
        assertEquals(0, calculator.multiply(1, 0),
                "Multiplication by zero should be zero");
    }
    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by one")
    void testMultiplicationByOne() {
        assertEquals(10, calculator.multiply(1, 10),
                "Multiplication ten by one should be ten");
        assertEquals(5, calculator.multiply(1, 5),
                "Multiplication five by one should be five");
    }
    @Test
    @DisplayName("Addition of calculator")
    void testAdd() {
        assertEquals(7, calculator.add(3, 4),
                "Addition should work");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure correct addition with zero")
    void testAdditionWithZero() {
        assertEquals(5, calculator.add(5, 0),
                "Addition with zero should be the same number");
        assertEquals(-3, calculator.add(0, -3),
                "Addition with zero should be the same number");
    }

    @Test
    @DisplayName("Subtraction of calculator")
    void testSubtract() {
        assertEquals(5, calculator.subtract(8, 3),
                "Subtraction should work");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure correct subtraction by zero")
    void testSubtractionByZero() {
        assertEquals(5, calculator.subtract(5, 0),
                "Subtraction by zero should be the same number");
        assertEquals(-2, calculator.subtract(-2, 0),
                "Subtraction by zero should be the same number");
    }

    @Test
    @DisplayName("Division of calculator")
    void testDivide() {
        assertEquals(4, calculator.divide(12, 3),
                "Division should work");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure correct division by one")
    void testDivisionByOne() {
        assertEquals(7, calculator.divide(7, 1),
                "Division by one should be the same number");
        assertEquals(-5, calculator.divide(-5, 1),
                "Division by one should be the same number");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure correct division by non-zero number")
    void testDivisionByNonZero() {
        assertEquals(2, calculator.divide(10, 5),
                "Division by non-zero number should work");
        assertEquals(-3, calculator.divide(15, -5),
                "Division by non-zero number should work");
    }

    @Test
    @DisplayName("Ensure exception is thrown for division by zero")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0),
                "Division by zero should throw ArithmeticException");
    }
    //Zadanie 3
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void testMethod(int val1, int val2, int result) {
        Calculator calculator = new Calculator();
        assertEquals(result, calculator.multiply(val1, val2));
    }
}