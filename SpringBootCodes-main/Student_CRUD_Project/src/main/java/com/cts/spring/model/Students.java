package com.cts.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Students {
	@Id
	@NotNull(message = "stuid is mandatory")
	Integer stuid;

	@NotEmpty(message = "name cant be empty")
	@Size(min = 3, max = 50, message = "Name must be between 3 to 50 characters")
	String name;

	@NotEmpty(message = "dept is mandatory")
	String dept;

	@NotNull(message = "age is mandatory")
	@Positive(message = "age must be positive")
	@Min(value = 1, message = "age should be greater than or equal to 1")
	@Max(value = 100, message = "age should be less than or equal to 100")
	Integer age;
	Boolean regular;

	public Integer getStuid() {
		return stuid;
	}

	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getRegular() {
		return regular;
	}

	public void setRegular(Boolean regular) {
		this.regular = regular;
	}

	public Students() {
		super();
	}

	public Students(Integer stuid, String name, String dept, Integer age, Boolean regular) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.dept = dept;
		this.age = age;
		this.regular = regular;
	}

	@Override
	public String toString() {
		return "Students [Id=" + stuid + ", Name=" + name + ", Department=" + dept + ", Age=" + age + ", Regular="
				+ regular + "]";
	}

}
