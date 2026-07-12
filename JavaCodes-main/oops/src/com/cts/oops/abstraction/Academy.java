package com.cts.oops.abstraction;

public abstract class Academy {
	
	String name; // normal variable (instance)
	
	public Academy(String name) {
		super();
		this.name = name;
	}

	public abstract void getAssessment(); // Abstract method
	
	//	Concreate Method (Non-abstract method)
	public void getWorkingDays() {
		System.out.println("Monday to Friday");
	}
}
