package com.cts.springjpa.spring_jpa_crud;

//import com.cts.springjpa.model.Student;
import com.cts.springjpa.service.StudentServiceImpl;

public class App {
	public static void main(String[] args) {
		StudentServiceImpl service = new StudentServiceImpl();
//		Student student = new Student(1006, "Pratham", "CSE");
//		service.addStudent(student);
//		service.deleteStudent(1002);
		service.getStudents().forEach(System.out::println);
	}
}
