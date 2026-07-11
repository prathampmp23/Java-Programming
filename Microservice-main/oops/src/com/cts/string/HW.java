package com.cts.string;

public class HW {

	public static void main(String[] args) {
		String str = "welcome to java programming";
		String arr[] = str.split(" ");

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			String curr = arr[i];
			char fc = Character.toUpperCase(curr.charAt(0));
			sb.append(fc);
			sb.append(curr.substring(1));
			if (i < arr.length - 1)
				sb.append(" ");
		}
		System.out.println(str);
		System.out.println(sb.toString());
	}

}