package com.cts.jdbc.dao;

import java.util.List;

import com.cts.jdbc.model.Employee;

public interface EmployeeDao {
	public List<Employee> displayEmployees();
	public boolean addEmployee(Employee employee);
	public boolean deleteEmployee(int empid);
}
