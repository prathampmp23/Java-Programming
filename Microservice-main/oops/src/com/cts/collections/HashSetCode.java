package com.cts.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class HashSetCode {

	public static void main(String[] args) {
//		do not maintain insertion order
		Set<Integer> set = new HashSet<>();
		set.add(null);
		set.add(null);
		set.add(0);
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set);

//		maintain insertion order
		Set<Integer> lSet = new LinkedHashSet<>();
		lSet.add(0);
		lSet.add(1);
		lSet.add(2);
		lSet.add(3);
		System.out.println(lSet);

//		maintain Sorted order
		Set<Integer> tSet = new TreeSet<>();
		tSet.add(0);
		tSet.add(3);
		tSet.add(1);
		tSet.add(5);
		System.out.println(tSet);
		
		Set<Employee> empSet = new TreeSet<>();
		empSet.add(new Employee(001, "Pratham", "Maharashtra", LocalDate.parse("2003-10-23")));
		empSet.add(new Employee(002, "Suhas", "Karnataka", LocalDate.parse("2003-06-19")));
		empSet.add(new Employee(003, "Kartik", "Andra", LocalDate.parse("2005-03-11")));

//		System.out.println(empSet); // ClassCastException before using Comparator (compareTo())
		
		for(Employee e : empSet) {
			System.out.println(e);
		}
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(001, "Pratham", "Maharashtra", LocalDate.parse("2003-10-23")));
		employeeList.add(new Employee(002, "Suhas", "Karnataka", LocalDate.parse("2003-06-19")));
		employeeList.add(new Employee(003, "Kartik", "Andra", LocalDate.parse("2005-03-11")));

		Collections.sort(employeeList, new SortedById());
		System.out.println(employeeList);
		
		Collections.sort(employeeList, new SortByName());
		System.out.println(employeeList);
		
		Collections.sort(employeeList, new SortByDate());
		System.out.println(employeeList);
		
	}

}
