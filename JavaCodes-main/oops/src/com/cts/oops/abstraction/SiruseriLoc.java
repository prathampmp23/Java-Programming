package com.cts.oops.abstraction;

public class SiruseriLoc implements Location {

	@Override
	public void getProjectDetails() {
		System.out.println("Training Location");
	}

	public static void main(String[] args) {
		Location loc = new SiruseriLoc();
		loc.getProjectDetails();
		System.out.println(ORGANIZATION_NAME); // by default static and can't altered
	}

}
