package com.springDemo.service;

import java.util.List;

import com.springDemo.model.Books;

public interface BookService {
	
//	all methods are public abstract by default
	public List<Books> getAllBooks();
	public Books addBook(Books book);
	public Books searchBook(int bookid);
	public boolean deleteBook(int bookid);
	public Books updateBook(Books book); // update cannot be done on primary key
	public List<Books> getBookByTitle(String title);
}
 