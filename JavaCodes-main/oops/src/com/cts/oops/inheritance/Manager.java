package com.cts.oops.inheritance;

import java.time.LocalDate;

public class Manager extends Employee {
	private String managerId;
	private String department;

	public Manager(Integer empId, String empName, String location, LocalDate date, String managerId,
			String department) {
		super(empId, empName, location, date);
		this.managerId = managerId;
		this.department = department;
	}

	public void displayDetails() {
		super.displayDetails();
		System.out.println("Manager Deteils");
	}

	@Override
	public String toString() {
		return "ManagerId=" + managerId + ", Department=" + department + ", EmpId=" + getEmpId() + ", EmpName="
				+ getEmpName() + ", Location=" + getLocation() + ", Date=" + getDate();
	}

	public static void main(String args[]) {
		Manager manager = new Manager(001, "Pratham", "Chennai", LocalDate.parse("2000-10-10"), "M001", "Sales");
		System.out.println(manager);
		manager.displayDetails();
	}
}
