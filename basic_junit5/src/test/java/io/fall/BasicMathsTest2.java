package io.fall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 *  Single test instance for all test cases 
 * 
 *      Still execution order of all methods can be random
 */
@TestInstance(Lifecycle.PER_CLASS)  
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
    public void testAdd() {
        int actual = maths.addition(Num1, Num2);
        int expected = Num1 + Num2;

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        int actual = maths.subtraction(Num1, Num2);
        int expected = Num1 - Num2;

        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        int actual = maths.multiplication(Num1, Num2);
        int expected = Num1 * Num2;

        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        int actual = maths.division(Num1, Num2);
        int expected = Num1 / Num2;

        assertEquals(expected, actual);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> maths.division(Num1, 0), "Divide By Zer0");
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
