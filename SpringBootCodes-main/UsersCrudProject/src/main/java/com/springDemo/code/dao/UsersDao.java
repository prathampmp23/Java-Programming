package com.springDemo.code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springDemo.code.model.Users;
import com.springDemo.code.model.UsersView;

public interface UsersDao extends JpaRepository<Users, Long> {
	Users findByEmail(String email);
	List<Users> findByName(String name);
	Users findByEmailAndActive(String email, Boolean active);
	List<Users> findByAgeGreaterThan(Integer age);
	List<Users> findByNameContaining(String name);
	List<Users> findByActiveTrue();
	List<Users> findByIdIn(List<Long> ids);
	List<Users> findByActiveOrderByNameAsc(Boolean active);
	@Query("SELECT MAX(u.age) FROM Users u")
	Integer findMaxAge();
	@Query("SELECT e.id as id, e.name AS name, e.email AS email FROM Users e")
	List<UsersView> fetchUsersView();
}
