package com.cts.string;

import java.util.StringTokenizer;

public class SplitingString {

	public static void main(String[] args) {
		String s1 = "java Code Programming";
		StringTokenizer st = new StringTokenizer(s1, " ");

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
