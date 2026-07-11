package com.cts.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfig {

	@Autowired
	BCryptPasswordEncoder bcrypt;

	@Bean
	BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
    UserDetailsService getUserDetailsService() {

		UserDetails user = User.withUsername("anil")
								.password("12345").passwordEncoder(bcrypt::encode)
								.roles("user")
								.build();

		UserDetails admin = User.withUsername("suresh")
								.password("67890").passwordEncoder(bcrypt::encode)
								.roles("admin")
								.build();

		return new InMemoryUserDetailsManager(user, admin);
	}
	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(request -> request
//				.requestMatchers("/","/info").permitAll()
//				.requestMatchers("/balance","/open","/update","/delete").authenticated())
//			.formLogin(Customizer.withDefaults()) // From form data
//			.httpBasic(Customizer.withDefaults()); // From url parameters
//		
//		return http.build();
//	}
	
//	Permit based on roles
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request -> request
				.requestMatchers("/","/info").permitAll()
				.requestMatchers("/balance","/open").hasRole("user")
				.requestMatchers("/update","/delete").hasAnyRole("admin", "user")
				.anyRequest().authenticated())
			.formLogin(Customizer.withDefaults()) // From form data
			.httpBasic(Customizer.withDefaults()); // From url parameters
		
		return http.build();
	}
} 
