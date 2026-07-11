package com.cts.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BussinessLogic {
	Logger logger = LoggerFactory.getLogger(BussinessLogic.class);

	public void placeOrder() {
		// logger.info("Log is called...!");
		System.out.println("Order is successfully placed");
	}

	public void placeShipment() {
		// logger.info("Log is called...!");
		System.out.println("Order is successfully shipped");
	}

	public void payment() {
		// logger.info("Log is called...!");
		System.out.println("Payment is successful");
	}

	public String getAddress() throws Exception {
		throw new Exception("Address is not valid..!");
		// return "Hyderabad";
	}
}
