package com.cts.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cts.spring.Exception.StudentNotFoudException;
import com.cts.spring.dao.StudentsDao;
import com.cts.spring.model.Students;
import com.cts.spring.model.StudentsView;

@Service
public class StudentsServiceImp implements StudentsService {

	@Autowired
	StudentsDao dao;

	@Override
	public List<Students> findAll() {
		return dao.findAll();
	}
	
	public Students findByStuid(Integer stuid) {
		return dao.findById(stuid).orElseThrow(() -> new StudentNotFoudException(stuid));
	}

	@Override
	public Students addStudent(Students student) {
		return dao.save(student);
	}

	@Override
	public List<Students> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Students> findByDept(String dept) {
		return dao.findByDept(dept);
	}

	@Override
	public List<Students> findByDeptAndRegular(String Dept, Boolean Regular) {
		return dao.findByDeptAndRegular(Dept, Regular);
	}

	@Override
	public List<Students> findByNameOrDept(String name, String Dept) {
		return dao.findByNameOrDept(name, Dept);
	}

	@Override
	public List<Students> findByAgeGreaterThan(Integer age) {
		return dao.findByAgeGreaterThan(age);
	}

	@Override
	public List<Students> findByAgeLessThan(Integer age) {
		return dao.findByAgeLessThan(age);
	}

	@Override
	public List<Students> findByAgeBetween(Integer start, Integer end) {
		return dao.findByAgeBetween(start, end);
	}

	@Override
	public List<Students> findByNameContaining(String name) {
		return dao.findByNameContaining(name);
	}

	@Override
	public List<Students> findByNameStartsWith(String prefix) {
		return dao.findByNameStartsWith(prefix);
	}

	@Override
	public List<Students> findByNameEndsWith(String suffix) {
		return dao.findByNameEndsWith(suffix);
	}

	@Override
	public List<Students> findByNameIgnoreCase(String name) {
		return dao.findByNameIgnoreCase(name);
	}

	@Override
	public List<Students> findByRegularTrue() {
		return dao.findByRegularTrue();
	}

	@Override
	public List<Students> findByRegularFalse() {
		return dao.findByRegularFalse();
	}

	@Override
	public List<Students> findByStuidIn(List<Integer> stuid) {
		return dao.findByStuidIn(stuid);
	}

	@Override
	public List<Students> findByDeptNotIn(List<String> Depts) {
		return dao.findByDeptNotIn(Depts);
	}

	@Override
	public List<Students> findByDeptIsNull() {
		return dao.findByDeptIsNull();
	}

	@Override
	public List<Students> findByDeptIsNotNull() {
		return dao.findByDeptIsNotNull();
	}

	@Override
	public List<Students> findByRegularOrderByNameAsc(Boolean Regular) {
		return dao.findByRegularOrderByNameAsc(Regular);
	}

	@Override
	public List<Students> findByAgeGreaterThanOrderByAgeDesc(Integer age) {
		return dao.findByAgeGreaterThanOrderByAgeDesc(age);
	}

	@Override
	public Integer findMaxAge() {
		return dao.findMaxAge();
	}

	@Override
	public List<StudentsView> fetchStudentsView() {
		return dao.fetchStudentsView();
	}

	public List<Students> findStudentsWithSorting(String field) {
		return dao.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	public Page<Students> findStudentsWithPagination(int offset, int pageSize) {
		Page<Students> Students = dao.findAll(PageRequest.of(offset, pageSize));
		return Students;
	}

	public Page<Students> findStudentsWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Students> Students = dao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		return Students;
	}

}
