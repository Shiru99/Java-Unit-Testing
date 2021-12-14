package io.fall;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@EnabledOnOs({OS.LINUX, OS.MAC})
@DisabledOnOs(OS.WINDOWS)
public class BasicMathsTest {

    @RepeatedTest(value = 3, name = "{displayName} - {currentRepetition}/{totalRepetitions}")
    @DisplayName("Generate random number")
    @EnabledOnJre({JRE.JAVA_14, JRE.JAVA_11})
    // @DisabledForJreRange(max = JRE.JAVA_11)
    @EnabledIfEnvironmentVariable(named = "GDMSESSION", matches = "ubuntu")
    @EnabledIfSystemProperty(named = "java.vm.vendor", matches = "Oracle.*")
    public void gamble() {
        double rand = Math.random();
        assertTrue(rand>0);
    }

    // JUnit Assumptions helps us in skipping a test for some specific scenarios
    @RepeatedTest(value = 5, name = "{displayName} - {currentRepetition}/{totalRepetitions}")
    @DisplayName("assumption test")
    public void serverConnectionTest(){
        boolean isServerUp=false;

        double rand = Math.random();
        if(rand<0.2){
            isServerUp = true;
        }
        
        assumeTrue(isServerUp);

        System.out.println("Server is up, continue server side testing");
    }


    @BeforeAll
	static void setup(){
		System.out.println("static @BeforeAll executed");
	}
    
    BasicMaths maths; 

    @BeforeEach
	void setupThis(){
		System.out.println("@BeforeEach executed");
        maths = new BasicMaths();
	}

    private static final int Num1 = 1;
    private static final int Num2 = 2;

    @Test
    public void testAdd() {
        int actual = maths.addition(Num1, Num2);
        int expected = Num1+Num2;
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        int actual = maths.subtraction(Num1, Num2);
        int expected = Num1-Num2;
        
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        int actual = maths.multiplication(Num1, Num2);
        int expected = Num1*Num2;
        
        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        int actual = maths.division(Num1, Num2);
        int expected = Num1/Num2;
        
        assertEquals(expected, actual);
    }

    @Test
    public void testDivideByZero() {
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

    @AfterEach
	void tearThis(){
		System.out.println("@AfterEach executed");
	}

    @AfterAll
	static void tear(){
		System.out.println("static @AfterAll executed");
	}
}
