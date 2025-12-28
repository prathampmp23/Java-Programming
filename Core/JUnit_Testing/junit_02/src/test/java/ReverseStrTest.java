import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.junit.codes.ReverseStr;

public class ReverseStrTest {
    @Test
    public void test() {
        // Junit 4
        ReverseStr s = new ReverseStr();
        // Pass test case
        String actual = s.reverse("abc");
        String expected = "cba";
        assertEquals(expected, actual);

        // to make in line => right click on actual1 
        // >>> refactor > inline local variable
        assertEquals(s.reverse("mno"), "onm");
        assertEquals(s.reverse("avaJ"), "Java");
    }
}
