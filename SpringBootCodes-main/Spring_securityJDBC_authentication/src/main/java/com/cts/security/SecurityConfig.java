package com.cts.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
class SecurityConfig {
 
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    
    @Bean
    UserDetailsManager userDetailsService( DataSource dataSource, PasswordEncoder encoder) {
 
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        
        /*
         * User Management Methods -
			>> These come from UserDetailsManager:
			
			.createUser(UserDetails user) – Adds a new user to the database.
			.updateUser(UserDetails user) – Updates an existing user’s details.
			.deleteUser(String username) – Removes a user by username.
			.userExists(String username) – Checks if a user exists.
			.changePassword(String oldPassword, String newPassword) – Changes the current authenticated user’s password.
		*/
 
        if (!manager.userExists("kishore")) {
            manager.createUser(
                User.withUsername("kishore")
                    .password(encoder.encode("12345"))
                    .roles("USER")// ROLE_USER store in database
                    .build()
            );
        }
 
        if (!manager.userExists("prakash")) {
            manager.createUser(
                User.withUsername("prakash")
                    .password(encoder.encode("56789"))
                    .roles("ADMIN") // ROLE_ADMIN store in database
                    .build()
            );
        }
 
        return manager;
    }
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/ /**").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults());
 
        return http.build();
    }
} 
