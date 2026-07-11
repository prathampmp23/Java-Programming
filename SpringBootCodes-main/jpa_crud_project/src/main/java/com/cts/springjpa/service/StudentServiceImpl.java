package com.cts.springjpa.service;

import java.util.List;

import com.cts.springjpa.dao.StudentDao;
import com.cts.springjpa.dao.StudentDaoImpl;
import com.cts.springjpa.model.Student;

public class StudentServiceImpl implements StudentService {

	StudentDao dao;

	public StudentServiceImpl() {
		dao = new StudentDaoImpl();
	}

	@Override
	public List<Student> getStudents() {
		return dao.getStudents();
	}

	@Override
	public Student addStudent(Student student) {
		return dao.addStudent(student);
	}

	@Override
	public boolean deleteStudent(int stuid) {
		return dao.deleteStudent(stuid);
	}

}
