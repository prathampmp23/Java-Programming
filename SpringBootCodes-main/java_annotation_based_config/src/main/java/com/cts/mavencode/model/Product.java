package com.cts.mavencode.model;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Product {

	int pid;
	String name;
	String category;

	public Product() {
		pid = 1001;
		name = "laptop";
		category = "electorinics";
	}

	public Product(int pid, String name, String category) {
		super();
		this.pid = pid;
		this.name = name;
		this.category = category;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@PostConstruct
	public void initMethod() {
		System.out.println("This method is called at intialization");
	}

	@PreDestroy
	public void destroyMethod() {
		System.out.println("This method is called before the bean destroy");
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", category=" + category + "]";
	}
}
