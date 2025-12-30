import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.junit.codes.Shapes;

public class ShapeTest {
    Shapes s = new Shapes();

    @Test
    public void testComputeSquareArea() {
        // message display when test case fails
        // in this string evaluated by asserEquals is done in both success and fail case
        assertEquals(529, s.compureSquareArea(23), "Area of Square computed wrong");
    }

    @Test
    public void testComputeSquareArea2() {
        // ** efficient way **
        // using "supplier interface" (it is functional interface) for message display
        // this () -> "Area..." only evaluated by asserEquals if test case fails
        assertEquals(59, s.compureSquareArea(23), () -> "Area of Square computed wrong");
    }

    @Test
    public void testComputeCircleArea() {
        assertEquals(12.566370614359172, s.compureCircleArea(2), "Area of circle computed wrong");
    }

    @Test
    public void testComputeCircleArea2() {
        // if not match then pass else fails
        assertNotEquals(12, s.compureCircleArea(2), "Area of circle computed wrong");
    }

    @Test
    public void test() {
        String str = "Java";
        assertTrue(str.equals("Java"));
    }

    @Test
    public void test2() {
        String str = "Java";
        assertFalse(str.length() > 5 );
    }
}
