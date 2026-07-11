package com.cts.mavencode.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// Spring Lifecycle Interfaces
/* 
    InitializingBean - 
	Requires implementing afterPropertiesSet().
	Called after Spring sets all bean properties (i.e., after dependency injection is complete).
	
	DisposableBean -
	Requires implementing destroy().
	Called when the bean is being destroyed (e.g., when the application context is closed).
*/
public class Flight implements InitializingBean, DisposableBean {

	String flightId;
	String provider;
	String source;
	String destination;

	public Flight() {

	}

	public Flight(String flightId, String provider, String source, String destination) {
		super();
		this.flightId = flightId;
		this.provider = provider;
		this.source = source;
		this.destination = destination;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", provider=" + provider + ", source=" + source + ", destination="
				+ destination + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean Initialization is done..!");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean is destroyed..!");
	}

	/*
	 * Lifecycle Flow in Spring When you run a Spring application with this bean:
	 * 	Spring creates the Flight object.
	 * 	Sets its properties (via constructor or setters).
	 * 	Calls afterPropertiesSet() → initialization logic.
	 * 	When the context shuts down, Spring calls destroy() → cleanup logic.
	 * 
	 * Why Use This Approach? 
	 * 	Ensures beans can run custom initialization (e.g.,
	 * 	open a database connection, validate data).
	 * 	Ensures beans can run custom destruction (e.g., close resources, release
	 * 	memory).
	 * 	Provides a standardized lifecycle hook without needing XML <init-method> or
	 * 	<destroy-method>.
	 */

}
