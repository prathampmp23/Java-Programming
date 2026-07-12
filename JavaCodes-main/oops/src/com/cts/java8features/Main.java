package com.cts.java8features;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
//		Anonymous inner class
		Academy academy = new Academy() {

			@Override
			public void getTraining() {
				System.out.println("Anonymous Inner type of abstract method");
			}
		};
		academy.getTraining(); // abstract
		academy.getInfo(); // default
		Academy.test(); // static

//		Stream APIs
		List<Integer> list = Arrays.asList(12, 23, 54, 10, 8, 5, 10, 8);

//		1.get even numbers from list (filter)
//		Convert from list to stream to list
		List<Integer> evenList = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(evenList);

//		using forEach loop
		list.stream().filter(n -> n % 2 == 0).forEach(i -> System.out.println(i));

//		method reference (::)
		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

//		2.Square of list elements (map)
		list.stream().map(n -> n * n).forEach(i -> System.out.println(i));
		list.stream().map(n -> n * n).forEach(System.out::println);
		System.out.println(list.stream().map(n -> n * n).collect(Collectors.toList()));

//		3.Distinct (Unique Elements)
		System.out.println(list.stream().distinct().collect(Collectors.toList()));

//		4.Sort list
		System.out.println(list.stream().sorted().collect(Collectors.toList())); // ASC
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())); // DSC

//		Count elements in list
		System.out.println(list.stream().count());

//		Date Format
		LocalDate date = LocalDate.now();
		System.out.println(date); // default format 2026-03-31

//		Custom Date Format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String formateDate = formatter.format(date);
		System.out.println(formateDate);

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE MMMM YYYY"); // full days in week name like
																						// Tuesday
//		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEE MM YYYY"); // shows 3 letters like Tue
		String formateDate1 = formatter1.format(date);
		System.out.println(formateDate1);

		
		
//		Stream on Object
		List<Employee> employees = Arrays.asList(
				new Employee(1, "Pratham", "Nagpur"),
				new Employee(2, "Suhas", "Karnataka"), 
				new Employee(3, "Rishabh", "Nagpur"),
				new Employee(4, "Kartik", "Andra"));

//		Filter Even EmpIds
		List<Employee> evenEmpId = employees.stream().filter(n -> n.getEmpId() % 2 == 0).collect(Collectors.toList());
		System.out.println(evenEmpId);

//		Filter Odd EmpIds
		employees.stream().filter(n -> n.getEmpId() % 2 != 0).forEach(i -> System.out.println(i.getEmpName()));

//		Map to join with (,)
		employees.stream().map(n -> n.getEmpId() + "," + n.getEmpName() + "," + n.getEmpLocation()).forEach(System.out::println);

//		Sort in Descending order of EmpId
		System.out.println(employees.stream().sorted((o1, o2) -> o2.getEmpId() - o1.getEmpId()).collect(Collectors.toList())); // ASC
	}
}
