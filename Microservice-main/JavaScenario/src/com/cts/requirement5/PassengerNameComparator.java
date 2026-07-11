package com.cts.requirement5;

import java.util.Comparator;

public class PassengerNameComparator implements Comparator<Seat> {

	@Override
	public int compare(Seat o1, Seat o2) {
		return o1.getPassengerName().compareTo(o2.getPassengerName());
	}

}
