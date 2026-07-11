package com.cts.string;

import java.util.Scanner;

public class FlushChar {
	
	public static String getSpecialChar(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				ans += " ";
			} else {
				ans += str.charAt(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String str = sc.next();
		System.out.println(FlushChar.getSpecialChar(str));
		sc.close();
	}

}
