package com.cts.testing;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestClass1 {

	@Test
	@Tag("smoke")
	void contextLoads1() {
		System.out.println("Test class 1 - Method 1");
	}

	@Test
	@Tag("health")
	void contextLoads2() {
		System.out.println("Test class 1 - Method 2");
	}

	@Test
	@Tag("sanity")
	void contextLoads3() {
		System.out.println("Test class 1 - Method 3");
	}

}
