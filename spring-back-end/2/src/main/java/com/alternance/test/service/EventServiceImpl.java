package com.alternance.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alternance.test.dto.MessageResponse;
import com.alternance.test.entity.Event;
import com.alternance.test.repository.IEventRepository;

@Service
public class EventServiceImpl implements IEventService {

	@Autowired
	IEventRepository er;

	@Override
	public MessageResponse ajoutEvent(Event event) {
		boolean exist = er.existsByTitreAndDate(event.getTitre(), event.getDate());
		if (exist) {
			return new MessageResponse(false, "Attention", "Event existe déjà!!");
		}
		
		er.save(event);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	@Transactional
	public MessageResponse deleteEvent(Long id) {
		Event event = getEventById(id);
		if (event == null) {
			return new MessageResponse(false, "Attention", "Event introuvable!!");
		}

		er.delete(event);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	@Transactional
	public MessageResponse updateEvent(Event event) {
		
		Event ev = getEventById(event.getId());
		if (ev == null) {
			return new MessageResponse(false, "Attention", "Event introuvable!!");
		}

		er.save(event);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	@Transactional
	public List<Event> getEvents() {
		return er.findAll();
	}

	@Override
	@Transactional
	public Event getEventById(Long id) {
		return er.findById(id).orElse(null);
	}
	
}
