package com.springDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Books {
	@Id 
	int bookid;
	String author;
	String title;
	String description;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Books(int bookid, String author, String title, String description) {
		super();
		this.bookid = bookid;
		this.author = author;
		this.title = title;
		this.description = description;
	}

	public Books() {
		super();
	}

	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", author=" + author + ", title=" + title + ", description=" + description
				+ "]";
	}

}
