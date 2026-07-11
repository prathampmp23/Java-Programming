package com.cts.spring.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.spring.dto.ErrorResponse;
import com.cts.spring.dto.ValidationErrors;

@RestControllerAdvice // -> mark it as global exception handler, if any exception occurs in controller it comes in this class
public class CommentGlobalExceptionHandlerClass {

	@ExceptionHandler(CommentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCommentExcpetion(CommentNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrors> handleValidationErrors(MethodArgumentNotValidException ex) {
		System.out.println("Inside the handler");
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		ValidationErrors response = new ValidationErrors(errors, LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
