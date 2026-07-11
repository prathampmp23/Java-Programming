package com.cts.jdbc.service;

import java.util.List;

import com.cts.jdbc.model.Employee;

public interface EmployeeService {
	public List<Employee> displayEmployees();
	public boolean addEmployee(Employee employee);
	public boolean deleteEmployee(int empid);
}
