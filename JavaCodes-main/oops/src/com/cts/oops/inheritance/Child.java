package com.cts.oops.inheritance;

public class Child extends Parent{

	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		
		Parent p1 = c;
		System.out.println("Storing parent sub class into super class object");

		Parent p2 = new Child(); // UpCasting (Runtime Polymorphism or Dynamic method dispatch)
		Parent p3 = p2;
		
		if(p2 instanceof Child) { // p -> not possible for p2 -> possible
//			Child c1 = (Child) p; // DownCasting (we get ClassCast exception)
			Child c2 = (Child) p2; // possible
			System.out.println("Downcasting possible");
		} else {
			System.out.println("Downcasting Not possible");
		}
	}

}
