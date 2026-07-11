package com.cts.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	int stuid;
	String name;
	String branch;

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Student(int stuid, String name, String branch) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.branch = branch;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", name=" + name + ", branch=" + branch + "]";
	}

}
