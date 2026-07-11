package com.cts.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentAopApplication implements CommandLineRunner {

	@Autowired
	BussinessLogic bl;

	public static void main(String[] args) {
		SpringApplication.run(StudentAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			bl.placeOrder();
			
			bl.placeShipment();
			bl.payment();

			bl.getAddress();

		} catch (Exception e) {

		}
	}

}
