package com.cts.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
 
    @GetMapping("/api/public/hello")
    public String publicHello() {
        return "Hello, world (public)!";
    }
 
    @GetMapping("/api/user/hello")
    public String userHello() {
        return "Hello, user!";
    }
 
    @GetMapping("/api/admin/hello")
    public String adminHello() {
        return "Hello, admin!";
    }
}
 