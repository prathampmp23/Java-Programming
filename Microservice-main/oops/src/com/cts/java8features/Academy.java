package com.cts.java8features;

@FunctionalInterface // only have one abstract method and more than one static default methods
public interface Academy {
	void getTraining(); // abstract method
	
//	static method
	static void test() {
		System.out.println("Static method");
	}
//	default method
	default void getInfo() {
		System.out.println("Default method");
	}
}
