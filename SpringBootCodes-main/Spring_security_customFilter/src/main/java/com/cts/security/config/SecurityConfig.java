package com.cts.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cts.security.filters.ApiKeyAuthFilter;

@Configuration
public class SecurityConfig {

	// @Autowired
	private final ApiKeyAuthFilter apiKeyAuthFilter;

	public SecurityConfig(ApiKeyAuthFilter apiKeyAuthFilter) {
		this.apiKeyAuthFilter = apiKeyAuthFilter;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()) // For REST APIs / demo; enable accordingly for forms
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/secure").authenticated()
						.requestMatchers("/public").permitAll()
				).httpBasic(h -> h.disable()); // optional: for quick testing
		// .httpBasic(Customizers.WithDefaults())
		// Register our custom filter BEFORE UsernamePasswordAuthenticationFilter
		http.addFilterBefore(apiKeyAuthFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
