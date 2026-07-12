package com.cts.string;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
////		Heap memory
//		String s1 = new String("Java Programming");
//		String s2 = new String("Java Programming");
//		
////		String constant pool
//		String s3 = "Java";
//		String s4 = "Java";
//		
//		System.out.println(s1 == s2); // false
//		System.out.println(s1.equals(s2)); // true 
//		// true because -> (String class override the object class .equals method)
//		
//		System.out.println(s3 == s4); // true 
//		System.out.println(s3.equals(s4)); // true
//	
//		System.out.println(s1.charAt(0));
//		System.out.println(s1.indexOf('P'));
////		System.out.println(s1.join(",",  s1,s3)); // 1st delimiter 2nd content
//		System.out.println(s1.connect(s3));
//		System.out.println(s1.intern()); //  move the heap area to string constant pool

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size:");
		int n = sc.nextInt();
		System.out.println("Enter array elements:");
		String arr[] = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		System.out.println("Enter word to find its location ");
		String word = sc.next();
		System.out.println(RevStrPosition.getElementPosition(arr, word));
		sc.close();
	}

}
