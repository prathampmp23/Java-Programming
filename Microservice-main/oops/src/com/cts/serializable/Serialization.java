package com.cts.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) throws IOException , ClassNotFoundException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\2492830\\Downloads\\oops\\src\\com\\cts\\serializable\\exp.txt");
		ObjectOutputStream ob = new ObjectOutputStream(file);

		Employee e = new Employee(01, "Pratham", "Nagpur");
		ob.writeObject(e);
		System.out.println("Employee object serialized");
	}

}
 