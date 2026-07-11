package com.cts.mavencode.model;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component // Marks this class as a Spring-managed bean. 
// Spring will automatically detect it during component scanning and register it in the application context.
public class Book {
	int isbn;
	String author;
	String name;

	public Book() {
		this.isbn = 1234;
		this.author = "John";
		this.name = "DevOps";
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
	
	// Jakarta Annotations API - 
	// These are Lifecycle annotations used by Spring to hook into bean initialization and destruction.
	@PostConstruct // → runs after bean initialization.
	public void beginmethod() {
		System.out.println("Executed at the time of initialization");
	}

	@PreDestroy // → runs before bean destruction.
	public void finalmethod() {
		System.out.println("Executed at the time of destroy");
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", name=" + name + "]";
	}

}
