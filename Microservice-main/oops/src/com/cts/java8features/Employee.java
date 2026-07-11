package com.cts.java8features;

import java.util.Objects;

public class Employee implements Cloneable {
	// Encapsulation (Private instance variable and getter & setters)
	private Integer empId;
	private String empName;
	private String empLocation;
	
	public Employee(Integer empId, String empName, String empLocation) {
		super(); // calls (Base class) Object class default constructor 
		this.empId = empId;
		this.empName = empName;
		this.empLocation = empLocation;
	}
	
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
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(empId, empLocation, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(empLocation, other.empLocation)
				&& Objects.equals(empName, other.empName);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empLocation=" + empLocation + "]";
	}
}
