package com.cts.collections;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{
	private Integer empId;
	private String empName;
	private String location;
	private LocalDate date;

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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", location=" + location + ", date=" + date + "]";
	}

	public Employee(Integer empId, String empName, String location, LocalDate date) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.location = location;
		this.date = date;
	}

	@Override
	public int compareTo(Employee o) {
		return this.empId - o.empId; // ASC order
//		return o.empId - this.empId; // DESC order
	}
	
}
