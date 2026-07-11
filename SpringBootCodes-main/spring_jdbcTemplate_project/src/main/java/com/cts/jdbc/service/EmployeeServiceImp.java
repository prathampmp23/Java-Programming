package com.cts.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.cts.jdbc.dao.EmployeeDao;
import com.cts.jdbc.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	@Override
	public List<Employee> displayEmployees() {
		return dao.displayEmployees();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return dao.addEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int empid) {
		return dao.deleteEmployee(empid);
	}
} 
