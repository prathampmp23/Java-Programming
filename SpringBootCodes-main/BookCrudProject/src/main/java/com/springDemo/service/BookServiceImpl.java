package com.springDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDemo.dao.BookDao;
import com.springDemo.model.Books;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;

	@Override
	public List<Books> getAllBooks() {
		return dao.findAll();
	}

	@Override
	public Books addBook(Books book) {
		return dao.save(book);
	}

	@Override
	public Books searchBook(int bookid) {
		return dao.findById(bookid).orElse(null);
	}

	@Override
	public boolean deleteBook(int bookid) {
		dao.deleteById(bookid);
		return true;
	}

	@Override
	public Books updateBook(Books book) {
		return dao.save(book);
	}

	@Override
	public List<Books> getBookByTitle(String title) {
		// Internal implementation 
		/*
			List<Books> books = getAllBooks() ;
			List<Books> data = books.stream()
								    .filter(p -> p.getTitle().equals(title))
								    .collect(Collectors.toList());
			return data;
		*/
		return dao.findAllByTitle(title);
	}

}
