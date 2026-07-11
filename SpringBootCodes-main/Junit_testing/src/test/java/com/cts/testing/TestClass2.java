package com.cts.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestClass2 {

	@Test
	@Tag("health")
	void contextLoads1() {
		System.out.println("Test class 2 - Method 1");
	}

	@Test
	@Tag("smoke")
	void contextLoads2() {
		System.out.println("Test class 2 - Method 2");
	}

	@Test
	@Tag("sanity")
	void contextLoads3() {
		System.out.println("Test class 2 - Method 3");
	}

}
