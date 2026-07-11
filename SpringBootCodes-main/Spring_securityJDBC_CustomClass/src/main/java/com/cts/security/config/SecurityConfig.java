package com.cts.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cts.security.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
 
    private final CustomUserDetailsService userDetailsService;
 
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
 
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // strong hashing
    }
 
//    DaoAuthenticationProvider child class which extend JdbcUserdetailsManager to use on custom objects , as JdbcUserdetailsManager use predefine table (users, authorities) 
    @Bean
    AuthenticationProvider authenticationProvider(PasswordEncoder encoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
      //  provider.setUserDetailsService(userDetailsService); // DAO lookup from custom tables
        provider.setPasswordEncoder(encoder);
        return provider;
    }
 
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationProvider authProvider) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // demo; enable as needed
            .authenticationProvider(authProvider)
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/public/**", "/h2-console/**", "/error").permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers("/user/**").hasRole("USER")
                    .anyRequest().authenticated()
            )
           // .headers(h -> h.frameOptions(f -> f.sameOrigin())) // H2 console frames
            .httpBasic(Customizer.withDefaults())              // quick demo login via HTTP Basic
            .formLogin(Customizer.withDefaults());
        return http.build();
    }
}
