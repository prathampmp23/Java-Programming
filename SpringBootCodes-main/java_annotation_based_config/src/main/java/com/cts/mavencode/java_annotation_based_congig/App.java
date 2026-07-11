package com.cts.mavencode.java_annotation_based_congig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.mavencode.config.ComponentConfigurations;
import com.cts.mavencode.model.Book;
import com.cts.mavencode.model.Order;
import com.cts.mavencode.model.Product;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ComponentConfigurations.class);

		Book book = context.getBean(Book.class);
		System.out.println(book);

		Order order = context.getBean(Order.class);
		System.out.println(order);

		Product p = context.getBean(Product.class);
		System.out.println(p);
		context.close();
	}
}
