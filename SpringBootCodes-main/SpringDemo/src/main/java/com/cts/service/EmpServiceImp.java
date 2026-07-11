package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee registerEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found" + id));
	}
 
	@Override
	public Employee updateEmployee(Integer id, Employee employee) {
//		Fetch First
		Employee emp = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
		emp.setEmpName(employee.getEmpName());
		emp.setAge(employee.getAge());
		emp.setLocation(employee.getLocation());
		return repository.save(emp);
	}

	@Override
	public void deleteEmployee(Integer id) {
		repository.deleteById(id);
	}

}
