package com.cts.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
 
//	Method level security annotations comes from dependency --> spring-security-config
    @PreAuthorize("hasRole('USER')")
    public String userOperation() {
        return "User operation executed";
    }
 
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOperation() {
        return "Admin operation executed";
    }
 
    @PreAuthorize("hasAnyRole('ADMIN','USER','MANAGER')")
    public String commonOperation() {
        return "Common operation executed";
    }
}
