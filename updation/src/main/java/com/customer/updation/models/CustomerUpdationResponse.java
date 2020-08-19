package com.customer.updation.models;

import org.springframework.stereotype.Component;

@Component
public class CustomerUpdationResponse {
	private String message;
	private long id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
