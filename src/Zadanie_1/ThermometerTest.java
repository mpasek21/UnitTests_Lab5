package Zadanie_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThermometerTest {
    Thermometer thermometer;

    @BeforeEach
    void init() {
        thermometer = new Thermometer(-70, 100);
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                thermometer.setCurrentTemp(101));
        assertEquals("Temperature must be within the specified range.", exception.getMessage());
    }
    @Test
    void addDegreesTest() {
        thermometer.setCurrentTemp(25);
        assertEquals(30, thermometer.addDegrees(5), "Adding degrees works");
    }

    @Test
    void subtractDegreesTest() {
        thermometer.setCurrentTemp(25);
        assertEquals(20, thermometer.subtractDegrees(5), "Subtracting degrees works");
    }

    @Test
    void isBelowZeroTest() {
        thermometer.setCurrentTemp(-5);
        assertTrue(thermometer.isBelowZero(), "Temperature below zero should return true");
        thermometer.setCurrentTemp(5);
        assertFalse(thermometer.isBelowZero(), "Temperature above zero should return false");
    }
    @Test
    void addDegreesExceptionTest() {
        thermometer.setCurrentTemp(100);
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                thermometer.addDegrees(1));
        assertEquals("Temperature exceeds the maximum limit.", exception.getMessage());
    }

    @Test
    void subtractDegreesExceptionTest() {
        thermometer.setCurrentTemp(-70);
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                thermometer.subtractDegrees(1));
        assertEquals("Temperature falls below the minimum limit.", exception.getMessage());
    }
}
