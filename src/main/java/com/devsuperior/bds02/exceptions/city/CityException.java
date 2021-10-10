package com.devsuperior.bds02.exceptions.city;

import org.springframework.http.HttpStatus;

public class CityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus status;
	
	public CityException(final HttpStatus status, final String msg) {
		super(msg);
		this.status = status;
	}

}
