import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.junit.Service.PurchasedCourse;
import com.junit.courses.JavaCourse;
import com.junit.courses.Junit5Course;
import com.junit.courses.SpringBootCourse;

public class PurchaseCourseTest {
    @Test
    public void purchaseCourseTest() {
        PurchasedCourse pc = new PurchasedCourse();
        boolean state = pc.proceedWithCourse(new JavaCourse()); // object injection
        assertTrue(state);
        pc.proceedWithCourse(new SpringBootCourse());
        pc.proceedWithCourse(new Junit5Course());
    }
}
