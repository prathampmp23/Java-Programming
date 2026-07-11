package com.springDemo.code;

import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersCrudProjectApplicationTests {
	
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

}
