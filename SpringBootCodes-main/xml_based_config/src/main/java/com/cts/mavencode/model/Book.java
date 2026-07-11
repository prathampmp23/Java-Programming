package com.cts.mavencode.model;

public class Book {
	int isbn;
	String author;
	String name;

	public Book() {

	}

	public Book(int isbn, String author, String name) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.name = name;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init() {
		System.out.println("Before initialization of Bean");
	}

	public void destroy() {
		System.out.println("Execute after Bean destroy");
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", name=" + name + "]";
	}

}
