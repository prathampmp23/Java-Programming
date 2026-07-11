package com.cts.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepository;
import com.cts.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("employee")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeRepository repository;

	@GetMapping("getAllEmployees")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();
	}

//	@PathVariable - empId is given in the Request URL
//	@GetMapping("getEmployeeById/{empId}")
//	public Employee getEmployeeById(@PathVariable Integer empId) {
//		return service.getEmployeeById(empId);
//	}

//	@RequestParam - empId is given in Request Headers (Params --> Postman)
	@GetMapping("getEmployeeById")
	public Employee getEmployeeById(@RequestParam Integer empId) {
		return service.getEmployeeById(empId);
	}

	@PostMapping("saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = service.registerEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
//	OR

//	@PostMapping("saveEmployee")
//	public Employee saveEmployee(@RequestBody Employee employee) {
//		return empService.registerEmployee(employee);
//	}

	@PutMapping("updateEmployee/{empId}")
	public Employee updateEmployee(@PathVariable Integer empId, @RequestBody Employee employee) {
		Employee emp = service.updateEmployee(empId, employee);
		return emp;
	}

	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> getMethodName(@PathVariable Integer id) {
		service.deleteEmployee(id);
		return new ResponseEntity<String>("Employee with id " + id +" deleted", HttpStatus.OK);
	}

}
