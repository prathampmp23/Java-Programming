import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import testarrays.SortArray;

// .PER_CLASS => inctance is created only once so it make @BeforeAll and @AfterAll without static
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 

// .PER_METHOD => inctance is created on each method call
// @TestInstance(TestInstance.Lifecycle.PER_METHOD) 
public class SortArrayTest {

    SortArrayTest() {
        System.out.println("test obj is created");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll test");
    }

    SortArray sa;

    @BeforeEach
    void init() {
        // use for initialization of resources before test
        sa = new SortArray();
        System.out.println("Before test");
    }

    @AfterEach
    void destroy() {
        // use for closing or clenup of resources after test
        System.out.println("After test");
    }

    @Test
    public void test() {
        int expted[] = { 1, 2, 3, 4, 5 };
        int actual[] = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expted, actual);

        // if different order but same
        int expted1[] = { 1, 2, 3, 4, 5 };
        int actual2[] = { 3, 4, 1, 5, 2 };
        Arrays.sort(actual2); // sort
        assertArrayEquals(expted1, actual2);
    }

    @Test
    public void testSortMethod() {

        int actual[] = { 2, 3, 5, 4, 1 };
        int expted[] = { 1, 2, 3, 4, 5 };
        sa.sortArr(actual);
        assertArrayEquals(expted, actual);
    }

    @Test
    public void testSortMethodException() {

        try {
            int actual[] = null;
            int expted[] = { 1, 2, 3, 4, 5 };
            sa.sortArr(actual);
            assertArrayEquals(expted, actual);
        } catch (NullPointerException e) {
            System.out.println("Exception generated");
        }

        // or

        // this not generate exception thats why fails
        // int actual[] = {1,2,3};
        // assertThrows(NullPointerException.class, () -> sa.sortArr(actual));

        // this generate exception thats why pass
        int actual2[] = null;
        assertThrows(NullPointerException.class, () -> sa.sortArr(actual2));

    }

    @Test
    public void testPerformance() {

        int actual[] = { 2, 3, 5, 4, 1 };
        // loop runs 1000000 times
        // assertTimeout(Duration.ofMillis(1), () -> sa.sortArr2(actual)); // fails
        assertTimeout(Duration.ofMillis(10), () -> sa.sortArr2(actual)); // pass
    }

}
