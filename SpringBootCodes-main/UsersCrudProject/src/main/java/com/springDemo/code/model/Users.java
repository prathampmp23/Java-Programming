package com.springDemo.code.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	private Long id;
	private String name;
	private String email;
	private Integer age;
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Users(Long id, String name, String email, Integer age, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.active = active;
	}

	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", active=" + active + "]";
	}

}
