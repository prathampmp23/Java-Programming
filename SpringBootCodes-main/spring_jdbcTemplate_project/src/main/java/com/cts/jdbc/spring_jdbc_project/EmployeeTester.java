package com.cts.jdbc.spring_jdbc_project;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.jdbc.config.EmployeeConfigs;
import com.cts.jdbc.model.Employee;
import com.cts.jdbc.service.EmployeeService;
import com.cts.jdbc.service.EmployeeServiceImp;

public class EmployeeTester {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfigs.class);

		Scanner sc = new Scanner(System.in);
		EmployeeService service = context.getBean(EmployeeServiceImp.class);

		// service.displayEmployees().forEach(System.out::println);

		System.out.println("Enter empid");
		int empid = sc.nextInt();

		System.out.println("Enter department");
		String dept = sc.next();

		System.out.println("Enter designation");
		String desg = sc.next();

		System.out.println("Enter Name");
		String name = sc.next();

		System.out.println("Enter Salary");
		int salary = sc.nextInt();

		Employee emp = new Employee(empid, dept, desg, name, salary);
		service.addEmployee(emp);
		System.out.println("Record Added..!");
		
		service.displayEmployees().forEach(System.out::println);

		System.out.println("Enter empid");
		int empID = sc.nextInt();

		boolean isDeleted = service.deleteEmployee(empID);
		if (isDeleted)
			System.out.println("Employee record deleted.!");
		else
			System.out.println("Not Deleted..!");

		service.displayEmployees().forEach(System.out::println);
		
		sc.close();
		context.close();
	}
}
