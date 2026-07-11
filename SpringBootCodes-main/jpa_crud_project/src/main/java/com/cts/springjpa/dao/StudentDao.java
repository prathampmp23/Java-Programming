package com.cts.springjpa.dao;

import java.util.List;

import com.cts.springjpa.model.Student;

public interface StudentDao {
	public List<Student> getStudents();
	public Student addStudent(Student student);
	public boolean deleteStudent(int stuid);
}
