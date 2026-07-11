package com.cts.mavencode.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cts.mavencode.model.Author;
import com.cts.mavencode.model.Flight;
import com.cts.mavencode.model.Publisher;

@Configuration // → tells Spring this class contains bean definitions.
public class JavaConfigs {

	// Each method annotated with @Bean → registers a bean in the Spring container.
	@Bean("publisher")
	public Publisher createPublisher() {
		return new Publisher(123, "TataMcGrawHill", createAuthor1());
	}

	@Bean("author1")
	public Author createAuthor1() {
		return new Author("John", "New York");
	}

	@Bean("author2")
	public Author createAuthor2() {
		return new Author("Bob", "Las Vegas");
	}

	@Bean("f1") // Singleton scope (default) → same instance reused.
	public Flight createFlight1() {
		return new Flight("AI452", "AirIndia", "Chennai", "Delhi");
	}

	@Bean("f2")
	@Scope("prototype") // Prototype scope → new instance created each time it’s requested.
	public Flight createFlight2() {
		return new Flight("6E598", "Indigo", "Hyderabad", "Chennai");
	}
}
