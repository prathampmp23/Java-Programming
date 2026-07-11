package com.cts.security.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Lazy
public class BankController {

	@GetMapping("/")
	public String home() {
		return "Welcome to Bank portal";
	}
	
	@GetMapping("/info")
	public String info() {
		return "Bank info account details";
	}
	
	@GetMapping("/open")
	public String openAccount() {
		return "New Bank account open";
	}
	
	@GetMapping("/balance")
	public String balance() {
		return "Account balance: $$$$$$";
	}
	
	@GetMapping("/update")
	public String updateAccount() {
		return "Bank account details are updated";
	}
	
	@GetMapping("/delete")
	public String deleteAccount() {
		return "Bank account deleted";
	}
	
}
