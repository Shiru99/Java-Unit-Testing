package io.fall;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BasicMathsTest {
    private static final int Num1 = 1;
    private static final int Num2 = 2;

    @Test
    public void testAdd() {
        System.out.println("testing Addition function...");
        BasicMaths maths = new BasicMaths();

        int actual = maths.addition(Num1, Num2);
        int expected = Num1+Num2;
        
        assertEquals(expected, actual);
        System.out.println("testing Addition function completed\n");
    }

    @Test
    public void testSubtract() {
        System.out.println("testing Subtraction function...");
        BasicMaths maths = new BasicMaths();

        int actual = maths.subtraction(Num1, Num2);
        int expected = Num1-Num2;
        
        assertEquals(expected, actual);
        System.out.println("testing Subtraction function completed\n");
    }

    @Test
    public void testMultiply() {
        System.out.println("testing Multiplication function...");
        BasicMaths maths = new BasicMaths();

        int actual = maths.multiplication(Num1, Num2);
        int expected = Num1*Num2;
        
        assertEquals(expected, actual);
        System.out.println("testing Multiplication function completed\n");
    }

    @Test
    public void testDivide() {
        System.out.println("testing Division function...");
        BasicMaths maths = new BasicMaths();

        int actual = maths.division(Num1, Num2);
        int expected = Num1/Num2;
        
        assertEquals(expected, actual);
        System.out.println("testing Division function completed\n");
    }

    @Test
    public void testAssertMethods() {
        System.out.println("Exploring different Assert methods");

        // assertEquals
        assertEquals(true, true, "Message - In case of test failure");
        assertEquals(true, 1+2==3);
        // assertEquals(true, "true");      // error

        assertTrue(true);
        assertFalse(false);
        assertNull(null);

        // assertArrayEquals
        int[] expected = {1,2,3};
        int[] actual = {1,2,3};
        assertArrayEquals(expected, actual);

        // AssertIterableEquals
        List<Integer> expectedList = List.of(1,2,3);
        List<Integer> actualList = List.of(1,2,3);
        assertIterableEquals(expectedList, actualList);

        System.out.println("done\n");
    }
}
