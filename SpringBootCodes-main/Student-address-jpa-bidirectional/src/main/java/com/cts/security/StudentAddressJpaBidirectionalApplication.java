package com.cts.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.security.model.Address;
import com.cts.security.model.Student;
import com.cts.security.repo.StudentRepository;

@SpringBootApplication
public class StudentAddressJpaBidirectionalApplication implements CommandLineRunner {
 
    @Autowired
    private StudentRepository studentRepository;
 
    public static void main(String[] args) {
        SpringApplication.run(StudentAddressJpaBidirectionalApplication.class, args);
    }
 
    @Override
    public void run(String... args) {
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Praveen");
 
        Address address = new Address();
        address.setAddressId(1);
        address.setStreet("MG Road");
        address.setZipcode("560001");
 
        student.setAddress(address);
        address.setStudent(student);
 
        studentRepository.save(student);
        System.out.println("Student - Address one to one bidirectional is done");
    }
}
