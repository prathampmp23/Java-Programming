package com.cts.spring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.spring.Exception.CommentNotFoundException;
import com.cts.spring.dto.ErrorResponse;
import com.cts.spring.model.Comments;
import com.cts.spring.service.CommnetsService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

	@Autowired
	CommnetsService service;

	@GetMapping()
	public List<Comments> getAllCommments() {
		return service.getAllComments();
	}

	@PostMapping
	public Comments addComment(@Valid @RequestBody Comments comment) {
		return service.addComment(comment);
	}

	@GetMapping("/{cid}")
	public Comments getCommentByCid(@PathVariable Integer cid) {
		return service.getCommentById(cid);
	}

//	 handle user defined exception
	@ExceptionHandler(CommentNotFoundException.class) // custom Exception
	public ResponseEntity<ErrorResponse> handleCommentExcpetion(CommentNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), LocalDateTime.now()); 
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
