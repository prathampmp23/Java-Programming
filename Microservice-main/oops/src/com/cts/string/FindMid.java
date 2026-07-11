package com.cts.string;

import java.util.Scanner;

public class FindMid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter even length word");
		String str = sc.next();
		if (str.length() % 2 != 0) {
			System.out.println("Invalid word");
			sc.close();
			return;
		}
		int i = str.length() / 2;
		System.out.println(str.charAt(i - 1) + "" + str.charAt(i));
		sc.close();
	}

}
