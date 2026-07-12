package com.cts.oops.inheritance;

import java.time.LocalDate;

public class Employee {
	private Integer empId;
	private String empName;
	private String location;
	private  LocalDate date;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Employee(Integer empId, String empName, String location, LocalDate date) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.location = location;
		this.date = date;
	}
	
	public void displayDetails() {
		System.out.println("Employee Deteils");
	}
}
