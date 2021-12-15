package io.fall;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Single test instance for all test cases
 * 
 * Still execution order of all methods can be random
 */
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Testing 2: ")
public class BasicMathsTest2 {

    BasicMaths maths;

    @BeforeAll
    void setup() {
        System.out.println("Non static @BeforeAll executed");
        maths = new BasicMaths();
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach executed");
    }

    private static final int Num1 = 1;
    private static final int Num2 = 2;

    @Test
    @DisplayName("Testing Add Method")
    public void testAdd() {
        int actual = maths.addition(Num1, Num2);
        int expected = Num1 + Num2;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing Subtract Method")
    public void testSubtract() {
        int actual = maths.subtraction(Num1, Num2);
        int expected = Num1 - Num2;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing Multiply Method")
    public void testMultiply() {
        int actual = maths.multiplication(Num1, Num2);
        int expected = Num1 * Num2;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing Divide Method")
    public void testDivide() {
        double actual = maths.division(Num1, Num2);
        double expected = Num1 / Num2;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing Divide Method : for 'Divide By Zer0'")
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> maths.division(Num1, 0), "Divide By Zer0");
    }

    @Test
    @DisplayName("Testing divide method for different scenario")
    public void testAllDivide() {
        assertAll(
                () -> assertEquals(1 / 2.0, maths.division(1, 2)),
                () -> assertEquals(-1 / 2.0, maths.division(-1, 2)),
                () -> assertEquals(1 / -2.0, maths.division(1, -2)),
                () -> assertEquals(-1 / -2.0, maths.division(-1, -2)),
                () -> assertThrows(ArithmeticException.class, () -> maths.division(1, 0)));
    }

    @Nested
    @DisplayName("Testing Divide Method")
    public class DivideTest {

        @Test
        @DisplayName(" : with +ve num")
        public void testDivideByPositive() {
            double actual = maths.division(Num1, Num2);
            double expected = Num1 / (double)Num2;

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName(" : with -ve num")
        public void testDivideByNegative() {
            double actual = maths.division(Num1, -1* Num2);
            double expected = Num1 / ((double) -1* Num2);

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName(" : with 0")
        public void testDivideByZero() {
            assertThrows(ArithmeticException.class, () -> maths.division(1, 0));
        }

    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    void tear() {
        System.out.println("Non static @AfterAll executed");
    }
}
