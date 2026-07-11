package com.cts.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.spring.dto.APIResponse;
import com.cts.spring.model.Students;
import com.cts.spring.model.StudentsView;
import com.cts.spring.service.StudentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	StudentsService service;

	@GetMapping
	public List<Students> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/stuid/{stuid}")
	public Students findByStuid(@PathVariable Integer stuid) {
		return service.findByStuid(stuid);
	}

	@PostMapping
	public Students addStudents(@Valid @RequestBody Students student) {
		return service.addStudent(student);
	}

	@GetMapping("/Dept/{dept}")
	public List<Students> getByDept(@PathVariable String dept) {
		return service.findByDept(dept);
	}

	@GetMapping("/name/{name}")
	public List<Students> getByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@GetMapping("/Dept/{dept}/regular/{regular}")
	public List<Students> findByDeptAndregular(@PathVariable String dept, @PathVariable Boolean regular) {
		return service.findByDeptAndRegular(dept, regular);
	}

	@GetMapping("/age/{age}")
	public List<Students> findByAgeGreaterThan(@PathVariable Integer age) {
		return service.findByAgeGreaterThan(age);
	}

	@GetMapping("/findids")
	public List<Students> findByStuidIn(@RequestBody List<Integer> stuid) {
		return service.findByStuidIn(stuid);
	}

	@GetMapping("/regular/{regular}")
	public List<Students> findByregularOrderByNameAsc(@PathVariable Boolean regular) {
		return service.findByRegularOrderByNameAsc(regular);
	}

	@GetMapping("/partialdata")
	public List<StudentsView> getPartialData() {
		return service.fetchStudentsView();
	}

	@GetMapping("/maxage")
	public Integer findMaxAge() {
		return service.findMaxAge();
	}

	@GetMapping("/sort/{field}")
	private APIResponse<List<Students>> getStudentsWithSort(@PathVariable String field) {
		List<Students> allStudents = service.findStudentsWithSorting(field);
		return new APIResponse<>(allStudents.size(), allStudents);
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Students>> getStudentsWithPagination(@PathVariable int offset,
			@PathVariable int pageSize) {
		Page<Students> StudentsWithPagination = service.findStudentsWithPagination(offset, pageSize);
		return new APIResponse<>(StudentsWithPagination.getSize(), StudentsWithPagination);
	}

	@GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	private APIResponse<Page<Students>> getStudentsWithPaginationAndSort(@PathVariable int offset,
			@PathVariable int pageSize, @PathVariable String field) {
		Page<Students> StudentsWithPagination = service.findStudentsWithPaginationAndSorting(offset, pageSize, field);
		return new APIResponse<>(StudentsWithPagination.getSize(), StudentsWithPagination);
	}
}
