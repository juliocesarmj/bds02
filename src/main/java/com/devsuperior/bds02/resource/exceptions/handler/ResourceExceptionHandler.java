package com.devsuperior.bds02.resource.exceptions.handler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.exceptions.city.CityDatabaseException;
import com.devsuperior.bds02.exceptions.city.CityException;
import com.devsuperior.bds02.exceptions.event.EventException;
import com.devsuperior.bds02.resource.exceptions.StandardError;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(CityException.class)
	public ResponseEntity<StandardError> handlerCityNotFoundException(CityException c, HttpServletRequest req) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resource not found.");
		err.setMessage(c.getMessage());
		err.setPath(req.getRequestURI());
		
		return ResponseEntity.status(status).body(err);	
	}
	
	@ExceptionHandler(CityDatabaseException.class)
	public ResponseEntity<StandardError> handlerCityDatabaseException(CityDatabaseException c, HttpServletRequest req) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Database Exception.");
		err.setMessage(c.getMessage());
		err.setPath(req.getRequestURI());
		
		return ResponseEntity.status(status).body(err);	
	}
	
	@ExceptionHandler(EventException.class)
	public ResponseEntity<StandardError> handlerEventNotFoundException(EventException c, HttpServletRequest req) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resource not found.");
		err.setMessage(c.getMessage());
		err.setPath(req.getRequestURI());
		
		return ResponseEntity.status(status).body(err);	
	}

}
