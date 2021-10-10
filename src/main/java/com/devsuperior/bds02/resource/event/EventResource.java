package com.devsuperior.bds02.resource.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.event.IEventService;

@RestController
@RequestMapping(value = "events")
public class EventResource {
	
	@Autowired
	private IEventService service;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EventDTO> put(@PathVariable Long id, @RequestBody EventDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.update(id, dto));
	}

}
