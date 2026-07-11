package com.cts.mavencode.java_class_based_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.mavencode.configs.JavaConfigs;
import com.cts.mavencode.model.Flight;
import com.cts.mavencode.model.Publisher;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(JavaConfigs.class);
		
		Publisher p = (Publisher) context.getBean("publisher");
		System.out.println(p);
		
		Flight flight1 = (Flight) context.getBean("f1");
		System.out.println(flight1);
		
		Flight flight2 = (Flight) context.getBean("f2");
		System.out.println(flight2.hashCode());
		
		Flight flight3 = (Flight) context.getBean("f2");
		System.out.println(flight3.hashCode());
		
		context.close();
	}
}
