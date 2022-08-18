package com.darby.services;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darby.models.Event;
import com.darby.repositories.IEventDAO;

@Service
public class EventServices {
	private static final Logger log = LogManager.getLogger(EventServices.class);

	private IEventDAO edao;
	
	@Autowired
	public EventServices(IEventDAO edao) {
		super();
		this.edao = edao;
	}
	
	public List<Event> findAll() {
		return edao.findAll();
	}
	
	public List<Event> findByGuest(int id) {
		return edao.findByUserList_userID(id);
	}
	
	public List<Event> addEvent(Event ev) {
		edao.save(ev);
		return edao.findAll();
	}

	public Event updateEvent(Event ev) {
		return edao.save(ev);
	}


}
