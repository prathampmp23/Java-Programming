package com.cts.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.entity.Employee;

@Service
public interface EmployeeService {
//	CREATE - create new Employee
	Employee registerEmployee(Employee employee);
//	READ - Get all
	List<Employee> getAllEmployees();
//	Get EmployeeBy Id
	Employee getEmployeeById(Integer id);
//	Update Employee
	Employee updateEmployee(Integer id, Employee employee);
//	Delete Employee
	void deleteEmployee(Integer id);
}
