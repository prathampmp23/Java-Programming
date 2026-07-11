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
        student.setName("K Prasad");
 
        Address address = new Address();
        address.setStreet("Chankyapuri");
        address.setCity("Delhi");
        address.setState("Delhi");
        address.setZipcode("110021");
 
        student.setAddress(address);
 
        studentRepository.save(student);
 
        System.out.println("Unidirectional One-to-One data saved successfully");
    }
}
