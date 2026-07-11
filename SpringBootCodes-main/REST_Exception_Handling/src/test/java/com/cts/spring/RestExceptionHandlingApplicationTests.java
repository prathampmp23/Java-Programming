package com.cts.spring;

import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestExceptionHandlingApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Method 1");
	}
	@Test
	void contextLoads2() {
//		System.out.println("Method 2");
		fail("This method fail");
	}
	@Test
	@Disabled // to test without this method ignore this test
	void contextLoads3() {
		System.out.println("Method 3");
		System.out.println("Pratam");
	}

}
