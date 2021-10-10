package com.devsuperior.bds02.services.event;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.exceptions.event.EventException;
import com.devsuperior.bds02.repositories.event.IEventRepository;

@Service
public class EventService implements IEventService {

	@Autowired
	private IEventRepository repository;

	private static final String MSG_INTERNAL_SERVER_ERROR = "Internal error identified. Contact support";
	private static final String MSG_NOT_FOUND = "Object not found.";
	
	@Transactional
	@Override
	public EventDTO update(Long id, EventDTO dto) {
		
		try {
			Optional<Event> result = this.repository.findById(id);
			
			if(result.isPresent()) {
				
				Event entity = result.get();
				
				entity.setName(dto.getName());
				entity.setDate(dto.getDate());
				entity.setUrl(dto.getUrl());
				entity.setCity(new City(dto.getCityId(), null));
				
				this.repository.save(entity);
				
				return new EventDTO(entity);
			}
			throw new EventException(HttpStatus.NOT_FOUND, MSG_NOT_FOUND);
		} catch (EventException e) {
			throw e;
		}
		catch (Exception e) {
			throw new EventException(HttpStatus.INTERNAL_SERVER_ERROR, MSG_INTERNAL_SERVER_ERROR);
		}
	}

	

}
