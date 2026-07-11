package com.cts.requirement2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the reference id of the ticket: ");
		String refId = sc.nextLine();
		System.out.println("Enter the date of journey of the ticket:");
		String date = sc.nextLine();

//		Seat seat = new Seat();
		Ticket ticket = new Ticket();
		ticket.setRefId(refId);
		ticket.setDateOfJourney(LocalDate.parse(date));

		System.out.println("1.Add Seat");
		System.out.println("2.Delete Seat");
		System.out.println("3.Display Seats");
		System.out.println("4.Exit");

		int choice;
		boolean flag = true;

		while (flag == true) {
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: {
				System.out.println("Enter seat details:");
				String seatDetails = sc.nextLine();
				Seat s = Seat.createSeat(seatDetails);
				ticket.addSeatToList(s);
				break;
			}
			case 2: {
				System.out.println("Enter the seat number to be deleted:");
				Integer seatNo = Integer.parseInt(sc.nextLine());
				boolean deleted = ticket.removeSeatFromTicket(seatNo);
				if (deleted)
					System.out.println("Seat successfully deleted");
				else
					System.out.println("Seat not found");
				break;
			}
			case 3: {
				ticket.displaySeats();
				break;
			}
			case 4: {
				flag = false;
				System.out.println("Thank You");
				sc.close();
				break;
			}
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

}
