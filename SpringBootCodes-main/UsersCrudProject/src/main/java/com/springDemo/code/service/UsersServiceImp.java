package com.springDemo.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDemo.code.dao.UsersDao;
import com.springDemo.code.model.Users;
import com.springDemo.code.model.UsersView;

@Service
public class UsersServiceImp implements UsersService {
	
	@Autowired 
	UsersDao dao;

	@Override
	public Users findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public List<Users> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Users findByEmailAndActive(String email, Boolean active) {
		return dao.findByEmailAndActive(email, active);
	}

	@Override
	public List<Users> findByAgeGreaterThan(Integer age) {
		return dao.findByAgeGreaterThan(age);
	}

	@Override
	public List<Users> findByNameContaining(String name) {
		return dao.findByNameContaining(name);
	}

	@Override
	public List<Users> findByActiveTrue() {
		return dao.findByActiveTrue();
	}

	@Override
	public List<Users> findByIdIn(List<Long> ids) {
		return dao.findByIdIn(ids);
	}

	@Override
	public List<Users> findByActiveOrderByNameAsc(Boolean active) {
		return dao.findByActiveOrderByNameAsc(active);
	}

	@Override
	public List<Users> findAll() {
		return dao.findAll();
	}

	@Override
	public Users addUser(Users user) {
		return dao.save(user);
	}

	@Override
	public Integer findMaxAge() {
		return dao.findMaxAge();
	}

	@Override
	public List<UsersView> fetchUsersView() {
		return dao.fetchUsersView();
	}

}
