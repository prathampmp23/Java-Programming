package com.cts.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private final BusinessService service;

	public DemoController(BusinessService service) {
		this.service = service;
	}

	@GetMapping("/manager")
	public String managerApi() {
		return service.userOperation();
	}

	@GetMapping("/user")
	public String userApi() {
		return service.userOperation();
	}

	@GetMapping("/admin")
	public String adminApi() {
		return service.adminOperation();
	}

	@GetMapping("/common")
	public String commonApi() {
		return service.commonOperation();
	}
}
