package com.cts.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization  {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream("C:\\Users\\2492830\\Downloads\\oops\\src\\com\\cts\\serializable\\exp.txt");
		ObjectInputStream is = new ObjectInputStream(file);
		
		Employee e = (Employee) is.readObject();
		System.out.println(e);
		System.out.println("Employee object Deserialized");

	}

}
