package com.cts.oops;

import java.util.Scanner;

public class Requirement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter seat 1 details: ");
		String seat1 = sc.nextLine();
		System.out.println("Enter seat 2 details: ");
		String seat2 = sc.nextLine();

		seat1.trim();
		seat2.trim();

		String details1[] = seat1.split(",");
		String details2[] = seat2.split(",");

		// Seat ( Integer seatNo, String type, Double price, String passengerName,String gender )

		Seat s1 = new Seat();
		s1.setSeatno(Integer.parseInt(details1[0]));
		s1.setType(details1[1]);
		s1.setPrice(Double.parseDouble(details1[2]));
		s1.setPassengerName(details1[3]);
		s1.setGender(details1[4]);

		Seat s2 = new Seat();
		s2.setSeatno(Integer.parseInt(details2[0]));
		s2.setType(details2[1]);
		s2.setPrice(Double.parseDouble(details2[2]));
		s2.setPassengerName(details2[3]);
		s2.setGender(details2[4]);

		System.out.println(s1);
		System.out.println(s2);

		if (seat1.equals(seat2) == true) {
			System.out.println("Seat 1 is same as Seat 2.");
		} else {
			System.out.println("Seat 1 and Seat 2 are different.");
		}

		sc.close();
	}

}
