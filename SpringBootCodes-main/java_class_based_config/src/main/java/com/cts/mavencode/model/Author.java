package com.cts.mavencode.model;

public class Author {
	String name;
	String city;
	
	public Author() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Author(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", city=" + city + "]";
	}
}
