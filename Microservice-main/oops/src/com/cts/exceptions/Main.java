package com.cts.exceptions;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws CustomException {

		int a = 10;
		int b = 0;
		// System.out.println(a/b); // Unchecked Exception(Runtime Exception)

		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			System.out.println("Plaease enter b value greater than 0 as b is not " + e.getMessage());
		}

		System.out.println("Program Run sucessfully");

		// NullPointerException
		String s = null;
		// System.out.println(s.length());

		// ArrayIndexOutOfBoundsException
		int arr[] = new int[4];
		// System.out.println(arr[5]);
		
		Scanner sc = new Scanner(System.in);
		// int age = sc.nextInt(); // InputMismatchException
		
		// NumberFormatException
		String s1 = "abc";
//		int num = Integer.parseInt(s1);
//		System.out.println(num);
		
//		Custom Exception
		AgeValidation.ageCheck(10);
	}
}
