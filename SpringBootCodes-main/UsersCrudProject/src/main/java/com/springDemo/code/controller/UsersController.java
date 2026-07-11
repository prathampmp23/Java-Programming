package com.springDemo.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.code.model.Users;
import com.springDemo.code.model.UsersView;
import com.springDemo.code.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	UsersService service;

	@GetMapping
	public List<Users> findAll() {
		return service.findAll();
	}

	@PostMapping
	public Users addUser(@RequestBody Users user) {
		return service.addUser(user);
	}

	@GetMapping("/email/{email}")
	public Users getByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}

	@GetMapping("/name/{name}")
	public List<Users> getByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@GetMapping("/email/{email}/active/{active}")
	public Users findByEmailAndActive(@PathVariable String email, @PathVariable Boolean active) {
		return service.findByEmailAndActive(email, active);
	}

	@GetMapping("/age/{age}")
	public List<Users> findByAgeGreaterThan(@PathVariable Integer age) {
		return service.findByAgeGreaterThan(age);
	}

	@GetMapping("/findids")
	public List<Users> findByIdIn(@RequestBody List<Long> ids) {
		return service.findByIdIn(ids);
	}

	@GetMapping("/active/{active}")
	public List<Users> findByActiveOrderByNameAsc(@PathVariable Boolean active) {
		return service.findByActiveOrderByNameAsc(active);
	}

	@GetMapping("/partialdata")
	public List<UsersView> getPartialData() {
		return service.fetchUsersView();
	}

	@GetMapping("/maxage")
	public Integer findMaxAge() {
		return service.findMaxAge();
	}
}
 