package com.cts.springjpa.service;

import java.util.List;

import com.cts.springjpa.model.Student;

public interface StudentService {
	public List<Student> getStudents();
	public Student addStudent(Student student);
	public boolean deleteStudent(int stuid);
}
 