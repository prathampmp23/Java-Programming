
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.junit.codes.ReverseStr;

public class ReverseStrTest {
    // Junit 5
    ReverseStr s = new ReverseStr();

    @Test
    public void testOneWord() {
        assertEquals(s.reverse("mno"), "onm");
        assertEquals(s.reverse("avaJ"), "Java");
    }

    @Test
    public void testMultipleWords() {
        assertEquals(s.reverse("I am developer"), "repoleved ma I");
        assertEquals(s.reverse("Hii there"), "ereht iiH");
    }
}
