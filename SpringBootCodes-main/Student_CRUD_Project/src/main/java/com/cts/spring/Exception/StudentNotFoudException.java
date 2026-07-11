package com.cts.spring.Exception;

public class StudentNotFoudException extends RuntimeException {
	public StudentNotFoudException(int stuid) {
		super("Student with given id " + stuid + " not found!");
	}
}
