package com.cts.collections;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListCode {

	public static void main(String[] args) {
		// maintain insertion order
		// allow duplicates
		// allows multiple null values
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);

//		way 1 (Iterator)
//		Iterator common for all implemented classes
		System.out.println("way 1 (Iterator)");
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

//		way 2 (ListIterator only for List)
		System.out.println("way 2 (ListIterator only for List)");
		ListIterator<Integer> lItr = list.listIterator();
//		traversing forward direction
		while (lItr.hasNext()) {
			System.out.println(lItr.next());
		}
//		traversing backward direction
		while (lItr.hasPrevious()) {
			System.out.println(lItr.previous());
		}

//		way 3 (Normal for loop)
		System.out.println("way 3 (Normal for loop)");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

//		way 4 (Enhanced For loop)
		System.out.println("way 4 (Enhanced For loop)");
		for (Integer i : list) {
			System.out.println(i);
		}

//		way 5 (ForEach Loop)
		System.out.println("way 5 (ForEach Loop)");
		list.forEach(i -> System.out.println(i));

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(001, "Pratham", "Maharashtra", LocalDate.parse("2003-10-23")));
		employeeList.add(new Employee(002, "Suhas", "Karnataka", LocalDate.parse("2003-06-19")));
		employeeList.add(new Employee(003, "Kartik", "Andra", LocalDate.parse("2005-03-11")));

		System.out.println(employeeList);
		for (Employee e : employeeList) {
			System.out.println(e);
		}

		List<Integer> ageList = new ArrayList<>();
		for (Employee e : employeeList) {
			Period period = Period.between(e.getDate(), LocalDate.now());
			ageList.add(period.getYears());
		}
		
		System.out.println(ageList);
		for (Integer age : ageList) {
			System.out.println(age);
		}
	}

}
