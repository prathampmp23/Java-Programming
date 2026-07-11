package com.cts.collections;

import java.util.Comparator;

public class SortByDate implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

}
