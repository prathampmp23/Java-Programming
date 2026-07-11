package com.cts.dbconnection.demo_jdbc_connection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.dbconnection.config.JavaConfig;
import com.cts.dbconnection.service.DbService;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		DbService service = context.getBean(DbService.class);
		System.out.println(service.getDriverName());
		System.out.println(service.getDatabaseName());
		context.close();
	}
}
