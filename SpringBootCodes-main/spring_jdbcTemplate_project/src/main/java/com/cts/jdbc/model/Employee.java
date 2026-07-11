package com.cts.jdbc.model;

public class Employee {
	int empid;
	String dept;
	String desg;
	String name;
	int salary;

	public Employee() {

	}

	public Employee(int empid, String dept, String desg, String name, int salary) {
		super();
		this.empid = empid;
		this.dept = dept;
		this.desg = desg;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", dept=" + dept + ", desg=" + desg + ", name=" + name + ", salary="
				+ salary + "]";
	}
}
