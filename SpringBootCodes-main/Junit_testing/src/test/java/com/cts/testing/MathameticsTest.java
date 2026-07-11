package com.cts.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cts.testing.model.Mathametics;

class MathameticsTest {

	Mathametics math;

	@BeforeEach
	public void createMathObj() {
		math = new Mathametics();
	}

	@AfterEach
	public void disposeMathObj() {
		math = null;
	}

	@Test
	void testWhenBothArePositive() {
		assertEquals(20, math.add(10, 10));
	}

	@Test
	void testDivisionOfNumeratorDenominator() {
		assertEquals(20, math.div(16, 4));
	}

	@Test
	void testExceptionIsRaised() {
		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
			math.div(16, 0);
		});
		assertEquals("/ by zero", exception.getMessage());
	}

}
