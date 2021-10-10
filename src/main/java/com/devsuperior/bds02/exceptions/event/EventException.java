package com.devsuperior.bds02.exceptions.event;

import org.springframework.http.HttpStatus;

public class EventException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus status;
	
	public EventException(final HttpStatus status, final String msg) {
		super(msg);
		this.status = status;
	}

}
