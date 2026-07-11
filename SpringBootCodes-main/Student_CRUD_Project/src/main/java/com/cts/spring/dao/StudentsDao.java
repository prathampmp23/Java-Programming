package com.cts.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.spring.model.Students;
import com.cts.spring.model.StudentsView;

public interface StudentsDao extends JpaRepository<Students, Integer> {
	
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

	List<Students> findByStuidIn(List<Integer> ids);

	List<Students> findByDeptNotIn(List<String> Depts);

	List<Students> findByDeptIsNull();

	List<Students> findByDeptIsNotNull();

	List<Students> findByRegularOrderByNameAsc(Boolean Regular);

	List<Students> findByAgeGreaterThanOrderByAgeDesc(Integer age);
	
	@Query("SELECT MAX(s.age) FROM Students s")
	Integer findMaxAge();
	
	@Query("SELECT  s.name AS name, s.dept AS dept FROM Students s")
	List<StudentsView> fetchStudentsView();
}
