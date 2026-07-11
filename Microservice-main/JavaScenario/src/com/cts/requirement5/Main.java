package com.cts.requirement5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Seat> seatList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Seats");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String seat = sc.nextLine();
			seat.trim();
			String details[] = seat.split(",");

			Seat s = new Seat();
			s.setSeatno(Integer.parseInt(details[0]));
			s.setType(details[1]);
			s.setPrice(Double.parseDouble(details[2]));
			s.setPassengerName(details[3]);
			s.setGender(details[4]);
			seatList.add(s);
		}
		System.out.println("Enter type of sort");
		System.out.println("1.Sort By Seat No");
		System.out.println("2.Sort By Passenger Name");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			Collections.sort(seatList);
			System.out.format("%-8s %-12s %-5s %-15s %s\n", "Seat No", "Type", "Price", "Passenger Name", "Gender");
			for (Seat s : seatList) {
				System.out.format("%-8s %-12s %-5s %-15s %s\n", s.getSeatno(), s.getType(), s.getPrice(),
						s.getPassengerName(), s.getGender());
			}
			break;
		}
		case 2: {
			Collections.sort(seatList, new PassengerNameComparator());
			System.out.format("%-8s %-12s %-5s %-15s %s\n", "Seat No", "Type", "Price", "Passenger Name", "Gender");
			for (Seat s : seatList) {
				System.out.format("%-8s %-12s %-5s %-15s %s\n", s.getSeatno(), s.getType(), s.getPrice(),
						s.getPassengerName(), s.getGender());
			}
			break;
		}
		default:
			System.out.println("Invalid choice");
		}
		sc.close();
	}
}
