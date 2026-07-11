package com.cts.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {

	@GetMapping("/public")
	public String publicPing() {
		return "Public OK";
	}

	@GetMapping("/secure")
	public String secureHello(Authentication authentication) {
		return "Hello, " + (authentication != null ? authentication.getName() : "anonymous");
	}
}
