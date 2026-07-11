package com.cts.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {

	@GetMapping("/public")
	public String publicHello() {
		return "Public OK";
	}

	@GetMapping("/user")
	public String me(Authentication auth) {
		return "You are: " + (auth != null ? auth.getName() : "anonymous");
	}

	@GetMapping("/admin")
	public String admin(Authentication auth) {
		return "Admin panel for: " + (auth != null ? auth.getName() : "unknown");
	}
}
