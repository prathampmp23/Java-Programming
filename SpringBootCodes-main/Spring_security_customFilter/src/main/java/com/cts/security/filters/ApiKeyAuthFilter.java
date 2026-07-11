package com.cts.security.filters;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {

	private static final String API_KEY_HEADER = "X-API-KEY";
	private static final String EXPECTED_KEY = "secret123";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String apiKey = request.getHeader(API_KEY_HEADER);

		// Only set authentication if not already authenticated
		if (apiKey != null && EXPECTED_KEY.equals(apiKey)
				&& SecurityContextHolder.getContext().getAuthentication() == null) {

			// Create a simple Authentication object
			Authentication auth = new AbstractAuthenticationToken(List.of(new SimpleGrantedAuthority("ROLE_USER"))) {

				@Override
				public Object getCredentials() {
					return apiKey;
				}

				@Override
				public Object getPrincipal() {
					return "api-key-user";
				}
			};
			
			((AbstractAuthenticationToken) auth).setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			((AbstractAuthenticationToken) auth).setAuthenticated(true);

			SecurityContextHolder.getContext().setAuthentication(auth);
		}

		filterChain.doFilter(request, response);
	}
}
