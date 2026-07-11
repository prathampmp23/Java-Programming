package com.cts.mavencode.model;

// simple POJO (Plain Old Java Object) 
public class Publisher {
	String name;
	int id;
	Author author;

	public Publisher() {

	}

	public Publisher(int id, String name, Author author) {
		super();
		this.name = name;
		this.id = id;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Publisher [name=" + name + ", id=" + id + ", author=" + author + "]";
	}

}
