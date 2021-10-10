package com.devsuperior.bds02.services.event;

import com.devsuperior.bds02.dto.EventDTO;

public interface IEventService {

	EventDTO update(final Long id, final EventDTO dto);
}
