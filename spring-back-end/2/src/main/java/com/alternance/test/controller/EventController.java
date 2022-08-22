package com.alternance.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alternance.test.dto.MessageResponse;
import com.alternance.test.entity.Event;
import com.alternance.test.service.IEventService;

@RestController
@CrossOrigin("*")
@RequestMapping("/event")
public class EventController {
	@Autowired
	IEventService es;

	@GetMapping("")
	public List<Event> getEvents() {return es.getEvents() ; }
	
	@GetMapping("getEvent/{id}")
	public Event getEventById(@PathVariable Long id ) {return es.getEventById(id);}
	
	@PostMapping("addEvent")
	public MessageResponse addEvent(@RequestBody Event event) {return es.ajoutEvent(event);}
	
	@PutMapping("modifyEvent")
	public MessageResponse updateEvent(@RequestBody Event event) {return es.updateEvent(event);}
	
	@DeleteMapping("deleteEvent/{id}")
	public MessageResponse deleteEvent (@PathVariable Long id ) {return es.deleteEvent(id);} 

	
}