package com.cts.string;

public class Palindrome {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String str = "maam";
		sb.append(str);
		String rev = sb.reverse().toString();
		System.out.println(str.equals(rev));
	}

}
