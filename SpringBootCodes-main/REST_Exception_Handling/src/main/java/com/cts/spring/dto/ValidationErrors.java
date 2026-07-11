package com.cts.spring.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationErrors {

	Map<String, String> error;
	LocalDateTime localDateTime;
	
	public Map<String, String> getError() {
		return error;
	}
	public void setError(Map<String, String> error) {
		this.error = error;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public ValidationErrors(Map<String, String> error, LocalDateTime localDateTime) {
		super();
		this.error = error;
		this.localDateTime = localDateTime;
	}
	public ValidationErrors() {
		super();
	}

}
