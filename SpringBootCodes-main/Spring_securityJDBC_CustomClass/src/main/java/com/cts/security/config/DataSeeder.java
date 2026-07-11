package com.cts.security.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cts.security.model.UserAccount;
import com.cts.security.model.UserAuthority;
import com.cts.security.repo.UserAccountRepository;
import com.cts.security.repo.UserAuthorityRepository;

@Configuration
public class DataSeeder { 
	
	// CommandLineRunner - 
	/* 
	   In Spring Boot, the CommandLineRunner interface is a special callback interface 
	   that lets you run code immediately after the Spring Application Context is fully 
	   initialized but before the application is ready to serve requests.

		It’s often used for startup logic such as:
		
		1.Initializing data in a database
		2.Running background jobs
		3.Performing configuration checks
		5.Logging startup information 
		*/

	@Bean
	CommandLineRunner seedUsers(UserAccountRepository users, UserAuthorityRepository auths, PasswordEncoder encoder) {
		return args -> {
			if (users.findByUsername("alice").isEmpty()) {
				UserAccount alice = new UserAccount();
				alice.setUsername("alice");
				alice.setPassword(encoder.encode("12345"));
				alice.setEnabled(true);
				alice.setAccountNonExpired(true);
				alice.setAccountNonLocked(true);
				alice.setCredentialsNonExpired(true);

				alice = users.save(alice);

				UserAuthority userRole = new UserAuthority();
				userRole.setUser(alice);
				userRole.setAuthority("ROLE_USER");

				auths.save(userRole);
			}
			if (users.findByUsername("pratham").isEmpty()) {
				UserAccount alice = new UserAccount();
				alice.setUsername("pratham");
				alice.setPassword(encoder.encode("2003"));
				alice.setEnabled(true);
				alice.setAccountNonExpired(true);
				alice.setAccountNonLocked(true);
				alice.setCredentialsNonExpired(true);
				
				alice = users.save(alice);
				
				UserAuthority userRole = new UserAuthority();
				userRole.setUser(alice);
//				userRole.setAuthority("ROLE_USER");
				userRole.setAuthority("ROLE_ADMIN");
				
				auths.save(userRole); 
			}
		};
	}
}
