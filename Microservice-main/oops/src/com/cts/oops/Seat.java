package com.cts.oops;

import java.util.Objects;

public class Seat {
	private Integer seatno;
	private String type;
	private Double price;
	private String passengerName;
	private String gender;

	public Integer getSeatno() {
		return seatno;
	}

	public void setSeatno(Integer seatno) {
		this.seatno = seatno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Seat() {
	}

	public Seat(Integer seatno, String type, Double price, String passengerName, String gender) {
		super();
		this.seatno = seatno;
		this.type = type;
		this.price = price;
		this.passengerName = passengerName;
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, passengerName, price, seatno, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return Objects.equals(seatno, other.seatno) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "SeatNo:" + seatno + "\nType:" + type + "\nPrice:" + price + "\nPassengerName:" + passengerName
				+ "\nGender:" + gender + "\n";
	}
}
