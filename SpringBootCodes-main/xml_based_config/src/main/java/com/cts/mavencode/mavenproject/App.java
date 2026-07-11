package com.cts.mavencode.mavenproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.mavencode.model.Address;
import com.cts.mavencode.model.Book;
import com.cts.mavencode.model.Employee;
import com.cts.mavencode.model.Person;

public class App {
	public static void main(String[] args) {
//		Create the IOC container and load the beans.xml file using ClassPathXmlApplicationContext
		@SuppressWarnings("resource") 
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//		Ways of creating the bean
		Employee emp2 = context.getBean(Employee.class); // if one bean is present of type Employee 
		Employee emp = (Employee) context.getBean("emp"); // get by bean id (if more than one beans are there)
		Employee emp3 = context.getBean("emp", Employee.class); // preferred way both id and class type specified

		System.out.println(emp);
		System.out.println(emp2.hashCode());
		System.out.println(emp3.hashCode());
		
		Book book = context.getBean(Book.class);
		System.out.println(book);
		
		Address address = context.getBean(Address.class);
		System.out.println(address);
		
		Person person = context.getBean(Person.class);
		System.out.println(person);
		
	}
}
