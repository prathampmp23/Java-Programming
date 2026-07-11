package com.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.model.Books;
import com.springDemo.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired // implementation class object is injected
	BookService service;

	@GetMapping
	public List<Books> getAllBooks() {
		return service.getAllBooks();
	}

	@PostMapping
	public Books addBook(@RequestBody Books book) {
		return service.addBook(book);
	}

	@GetMapping("/book/{bookid}")
	public Books getMethodName(@PathVariable Integer bookid) {
		return service.searchBook(bookid);
	}

	@DeleteMapping("/{bookid}")
	public boolean deleteBook(@PathVariable Integer bookid) {
		return service.deleteBook(bookid);
	}

	@PatchMapping
	public Books updateBooks(@RequestBody Books book) {
		return service.updateBook(book);
	}

	@GetMapping("/{title}")
	public List<Books> getAllByTitle(@PathVariable String title) {
		return service.getBookByTitle(title);
	}

}
