package com.cts.oops.abstraction;

public class Mepz implements Training {

	@Override
	public void getProjectDetails() {
		System.out.println("Health Care Project");
	}

	@Override
	public void getTrainingTrack() {
		System.out.println("Java Track");
	}

	public static void main(String[] args) {
		Training t = new Mepz();
		t.getProjectDetails();
		t.getTrainingTrack();
	}
}
