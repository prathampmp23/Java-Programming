package com.cts.oops.abstraction;

public class Intern extends Academy {

	@Override
	public void getAssessment() {
		System.out.println("Profile Assessment with Intern");
	}

	public Intern(String name) {
		super(name);
	}
	
	public static void main(String[] args) {
		Academy academy = new Intern("Cognizant");
		academy.getAssessment();
		academy.getWorkingDays();
		System.out.println(academy.name);
	}
}
