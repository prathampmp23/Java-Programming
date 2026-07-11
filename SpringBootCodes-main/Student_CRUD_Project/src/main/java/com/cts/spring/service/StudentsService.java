package com.cts.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cts.spring.model.Students;
import com.cts.spring.model.StudentsView;

public interface StudentsService {

	List<Students> findAll();
	
	Students findByStuid(Integer stuid);

	Students addStudent(Students student);

	List<Students> findByName(String name);

	List<Students> findByDept(String dept);

	List<Students> findByDeptAndRegular(String Dept, Boolean Regular);

	List<Students> findByNameOrDept(String name, String Dept);

	List<Students> findByAgeGreaterThan(Integer age);

	List<Students> findByAgeLessThan(Integer age);

	List<Students> findByAgeBetween(Integer start, Integer end);

	List<Students> findByNameContaining(String name);

	List<Students> findByNameStartsWith(String prefix);

	List<Students> findByNameEndsWith(String suffix);

	List<Students> findByNameIgnoreCase(String name);

	List<Students> findByRegularTrue();

	List<Students> findByRegularFalse();

	List<Students> findByStuidIn(List<Integer> stuid);

	List<Students> findByDeptNotIn(List<String> Depts);

	List<Students> findByDeptIsNull();

	List<Students> findByDeptIsNotNull();

	List<Students> findByRegularOrderByNameAsc(Boolean Regular);

	List<Students> findByAgeGreaterThanOrderByAgeDesc(Integer age);

	Integer findMaxAge();
	
	List<StudentsView> fetchStudentsView();

	public List<Students> findStudentsWithSorting(String field);

	public Page<Students> findStudentsWithPagination(int offset, int pageSize);

	public Page<Students> findStudentsWithPaginationAndSorting(int offset, int pageSize, String field);

}
