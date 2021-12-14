package io.fall;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BasicMathsTest {

    @BeforeAll
	static void setup(){
		System.out.println("@BeforeAll executed");
	}
    
    private static final int Num1 = 1;
    private static final int Num2 = 2;

    @Test
    public void testAdd() {
        BasicMaths maths = new BasicMaths();

        int actual = maths.addition(Num1, Num2);
        int expected = Num1+Num2;
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        BasicMaths maths = new BasicMaths();

        int actual = maths.subtraction(Num1, Num2);
        int expected = Num1-Num2;
        
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        BasicMaths maths = new BasicMaths();

        int actual = maths.multiplication(Num1, Num2);
        int expected = Num1*Num2;
        
        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        BasicMaths maths = new BasicMaths();

        int actual = maths.division(Num1, Num2);
        int expected = Num1/Num2;
        
        assertEquals(expected, actual);
    }

    @Test
    public void testDivideByZero() {
        BasicMaths maths = new BasicMaths();
        assertThrows(ArithmeticException.class, ()->maths.division(Num1, 0) , "Divide By Zer0");
    }

    @Disabled
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

    @AfterAll
	static void tear(){
		System.out.println("@AfterAll executed");
	}
}
