package com.cts.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.security.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
