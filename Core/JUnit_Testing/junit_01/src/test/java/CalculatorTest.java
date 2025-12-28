import static org.junit.Assert.*;

import org.junit.Test;

import com.junit.codes.Calculator;

public class CalculatorTest {

    @Test
    public void test() {
        Calculator c = new Calculator(); // instance
        assertEquals("java", "java");

        int actual1 = c.multiply(10, 5);
        int expected1 = 50;
        assertEquals(expected1, actual1);

        int actual2 = c.divide(10, 5);
        int expected2 = 2;
        assertEquals(expected2, actual2);
    }
}