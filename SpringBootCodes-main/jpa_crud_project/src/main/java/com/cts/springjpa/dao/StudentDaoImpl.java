package com.cts.springjpa.dao;

import java.util.List;

import com.cts.springjpa.model.Student;
import com.cts.springjpa.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getStudents() {
		EntityManager entityManager = JpaUtil.getEntityManager();
		return entityManager
				.createQuery("from Student", Student.class) // JPQL (Java Persistence Query Language)
				.getResultList();
	}

	@Override
	public Student addStudent(Student student) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		entityManager.persist(student); // Converts Java object → database row
		txn.commit();
		return student;
	}

	@Override
	public boolean deleteStudent(int stuid) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		Student stu = entityManager.find(Student.class, stuid);
		entityManager.remove(stu);
		txn.commit();
		return true;
	}
 
} 
