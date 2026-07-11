package com.cts.spring.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
	String error;
	LocalDateTime datetime;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public ErrorResponse(String error, LocalDateTime datetime) {
		super();
		this.error = error;
		this.datetime = datetime;
	}

	public ErrorResponse() {
		super();
	}

}
