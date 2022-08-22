package com.alternance.test.service;

import java.util.List;

import com.alternance.test.dto.MessageResponse;
import com.alternance.test.entity.Event;

public interface IEventService {

	public MessageResponse ajoutEvent(Event event);
	
	public MessageResponse deleteEvent(Long id);
	
	public MessageResponse updateEvent(Event event);
		
	public List<Event> getEvents ();
	
	public Event getEventById(Long id);
}
