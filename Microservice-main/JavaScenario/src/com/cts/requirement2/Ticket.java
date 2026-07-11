package com.cts.requirement2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private String refId;
	private LocalDate dateOfJourney;
	private List<Seat> seatList;

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public List<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}

	public Ticket() {
		this.seatList = new ArrayList<>();
	}

	public Ticket(String refId, LocalDate dateOfJourney, List<Seat> seatList) {
		super();
		this.refId = refId;
		this.dateOfJourney = dateOfJourney;
		this.seatList = seatList;
	}

	public void addSeatToList(Seat seat) {
		seatList.add(seat);
		System.out.println("Seat successfully added");
	}

	public boolean removeSeatFromTicket(Integer seatNo) {
		for (int i = 0; i < seatList.size(); i++) {
			Seat s = seatList.get(i);
			if (seatNo.equals(s.getSeatno())) {
				seatList.remove(i);
				return true;
			}
		}
		return false;
	}

	public void displaySeats() {
		if(seatList.size() == 0) {
			System.out.println("No seats to show");
			return;
		}
		System.out.format("%-8s %-12s %-5s %-15s %s\n", "Seat No", "Type", "Price", "Passenger Name", "Gender");
		for (Seat s : seatList) {
			System.out.format("%-8s %-12s %-5s %-15s %s\n", s.getSeatno(), s.getType(), s.getPrice(),
					s.getPassengerName(), s.getGender());
		}
	}
}
