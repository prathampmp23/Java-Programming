package com.cts.exceptions;

public class CheckedExceptionDemo {

	public static void main(String[] args) {

		try {
			AgeValidation.ageCheck(16);
		} catch (CustomException e) {
			System.out.println("Checked Exception Caught:");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Resources closed!");
		}

		System.out.println("Program continues...");
	}

}
