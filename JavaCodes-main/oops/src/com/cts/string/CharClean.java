package com.cts.string;

import java.util.Scanner;

public class CharClean {
	
	public static String removeCharacter(String str, char ch) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch) {
				ans += str.charAt(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String str = sc.next();
		System.out.println("Enter character you want to clean:");
		char ch = sc.next().charAt(0);

		System.out.println("After Character cleaning:");
		System.out.println(CharClean.removeCharacter(str, ch));

//		String word = String.valueOf(ch);
//		String result = str.replace(word, "");
//		System.out.println(result);
		sc.close();
	}

}
