package com.cts.exceptions;

public class AgeValidation {
	public static void ageCheck(int age) throws CustomException { // checked Exception
		if (age < 18) {
//			try {
				throw new CustomException("Not eligible for vote");
//			} catch (CustomException e) {
//				 System.out.println(e.getMessage());
//			}
		} else {
			System.out.println("Eligible for vote");
		}
	}
}
