package com.cts.string;

import java.util.Scanner;

public class SumOfDigits {

	public static int sumOfDigits(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				sum += Integer.parseInt(String.valueOf(str.charAt(i)));
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String input :");
		String str = sc.next();
		System.out.println("SumOfDigits = " + sumOfDigits(str));
		sc.close();
	}

}
