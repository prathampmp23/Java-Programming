package com.cts.testing;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitTestingApplicationTests {

	@BeforeEach // method level
	public void beforeEachMethod() {
		System.out.println("This will execute before each method");
	}

	@AfterEach // method level
	public void afterEachMethod() {
		System.out.println("This will execute after each method");
	}

	@BeforeAll // class level
	public static void beforeAllMethod() {
		System.out.println("This will execute before all method");
	}

	@AfterAll // class level
	public static void afterAllMethod() {
		System.out.println("This will execute before all method");
	}

	@Test
	@DisplayName("Test case method") // give name to test
	void contextLoads1() {
		System.out.println("Method 1");
	}

	@Test
	void contextLoads2() {
//		System.out.println("Method 2");
		fail("Test case fails");
	}

	@Test
	@Disabled // ignore this test method or test will not be execute
	void contextLoads3() {
		System.out.println("Method 3");
	}

	@Test
	@Order(1) // execute first
	void contextLoads4() {
		System.out.println("Method 4");
	}

	@RepeatedTest(5)
	void repeat() {
		System.out.println("inside repeated test");
	}

	@RepeatedTest(5)
	void repeatedTest() {
		System.out.println("inside the repatead test..!");
	}

	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
		assertTrue(candidate.length() >= 5);
	}

	@Timeout(3)
	@Test
	void setUp() {
		// fails if execution time exceeds 5 seconds
		System.out.println("The metho is passed..!");
		try {
			Thread.sleep(4000);
		} catch (Exception e) {

		}
	}
}
