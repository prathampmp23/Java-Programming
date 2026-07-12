package com.cts.oops;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("Hello Java");
		Employee e1 = new Employee(001, "Pratham", "Nagpur");
 		System.out.println(e1);				
//		System.out.println(e1.getEmpId());				
//		System.out.println(e1.getEmpLocation());				
//		System.out.println(e1.getEmpLocation());	
		
		Employee e2 = new Employee(002, "Ram", "Pune");
		Employee e3 = new Employee(001, "Pratham", "Nagpur");
		
		System.out.println(e1.equals(e2));
		System.out.println(e1.equals(e3)); 
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		
		Employee e4 = new Employee(003, "Suhas", "Karnataka");
		
//		Cloning of object
		Employee e5 = (Employee) e4.clone();
		System.out.println(e5);
	}

}
