package com.cts.spring.Exception;

// custom Exception declaration (unchecked)
public class CommentNotFoundException extends RuntimeException {
	public CommentNotFoundException(int cid) {
		super("Comment with given id " + cid + " not found!");
	}
}
