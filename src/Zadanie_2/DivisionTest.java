package Zadanie_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
public class DivisionTest {
    @TestFactory
    Stream<DynamicTest> testDifferentDivisions() {
        Division calculator = new Division();
        int[][] data = new int[][]{{6, 2, 3}, {8, 4, 2}, {10, 5, 2}, {4, 0, 0}};

        return Arrays.stream(data).map(entry -> {
            int dividend = entry[0];
            int divisor = entry[1];
            int result = entry[2];

            return dynamicTest(dividend + " / " + divisor + " = " + result,
                    () -> {
                        if (divisor == 0) {
                            assertThrows(ArithmeticException.class, () -> calculator.divide(dividend, divisor),
                                    "Division by zero should throw ArithmeticException");
                        } else {
                            assertEquals(result, calculator.divide(dividend, divisor),
                                    "Division should be equal to the expected result");
                        }
                    });
        });
    }
}
