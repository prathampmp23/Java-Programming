package com.cts.oops.abstraction;

public class FullTimeEmployee extends Academy {

	public FullTimeEmployee(String name) {
		super(name);
	}

	@Override
	public void getAssessment() {
		System.out.println("Profile Assessment with FTE");
	}

	public static void main(String[] args) {
		Academy academy = new FullTimeEmployee("Cognizant");
		academy.getAssessment();
		academy.getWorkingDays();
	}
}
