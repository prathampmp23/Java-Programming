package com.springDemo.code.service;

import java.util.List;

import com.springDemo.code.model.Users;
import com.springDemo.code.model.UsersView;

public interface UsersService {
	List<Users> findAll();
	Users addUser(Users user);
	Users findByEmail(String email);
	List<Users> findByName(String name);
	Users findByEmailAndActive(String email, Boolean active);
	List<Users> findByAgeGreaterThan(Integer age);
	List<Users> findByNameContaining(String name);
	List<Users> findByActiveTrue();
	List<Users> findByIdIn(List<Long> ids);
	List<Users> findByActiveOrderByNameAsc(Boolean active);
	Integer findMaxAge();
	List<UsersView> fetchUsersView();
}
