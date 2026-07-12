package com.cts.requirement4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatBO {

	static List<Seat> seatList = new ArrayList<>();

	public List<Seat> findSeat(List<Seat> seatList, Integer seatNo) {
		List<Seat> seatNoList = new ArrayList<>();
		for (Seat s : seatList) {
			if (s.getSeatno() == seatNo) {
				seatNoList.add(s);
			}
		}
		return seatNoList;
	}
 
	public List<Seat> findSeat(List<Seat> seatList, String gender) {
		List<Seat> seatGenderList = new ArrayList<>();
		for (Seat s : seatList) {
			if (s.getGender().equals(gender)) {
				seatGenderList.add(s);
			}
		}
		return seatGenderList;
	}

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
		SeatBO sBO = new SeatBO();
//		System.out.println(seatList);
		System.out.println("Enter search type");
		System.out.println("1. By Seat No");
		System.out.println("2. By Gender");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Enter Seat No");
			int seatNo = sc.nextInt();
			List<Seat> seatNoList = new ArrayList<>();
			seatNoList = sBO.findSeat(seatList, seatNo);
			System.out.format("%-8s %-12s %-5s %-15s %s\n", "Seat No", "Type", "Price", "Passenger Name", "Gender");
			for (Seat s : seatNoList) {
				System.out.format("%-8s %-12s %-5s %-15s %s\n", s.getSeatno(), s.getType(), s.getPrice(),
						s.getPassengerName(), s.getGender());
			}
			break;
		}
		case 2: {
			System.out.println("Enter the Gender");
			String gender = sc.next();
			List<Seat> seatGenderList = new ArrayList<>();
			seatGenderList = sBO.findSeat(seatList, gender);
			System.out.format("%-8s %-12s %-5s %-15s %s\n", "Seat No", "Type", "Price", "Passenger Name", "Gender");
			for (Seat s : seatGenderList) {
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
