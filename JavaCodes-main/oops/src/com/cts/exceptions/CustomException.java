package com.cts.exceptions;

public class CustomException extends Exception { // Checked exception

	public CustomException(String msg) {
		super(msg); // calling Exception parameterized constructor
	} 

}
