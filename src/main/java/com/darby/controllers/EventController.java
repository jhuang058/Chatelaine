package com.darby.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.darby.models.Event;
import com.darby.repositories.IEventDAO;
import com.darby.services.EventServices;




@RestController
@RequestMapping(value = "/event")
@ResponseBody
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {
	
	@Autowired
	private EventServices es;
	
	@Autowired
	public EventController(EventServices es) {
		super();
		this.es = es;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Event> getAll() {
		return es.findAll();
	}

//	@GetMapping("date/{date}")
//	public ResponseEntity<List<Event>> findByDate(@PathVariable("date") Date date) {
//		List<Event> a = es.findByDate(date);
//		if (a == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
//	}
	
//	@GetMapping("creator/{userId}")
//	public ResponseEntity<List<Event>> findByCreator(@PathVariable("userId") int id) {
//		List<Event> events = es.findByCreator(id);
//		if (events == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(events);
//	}
	
	@GetMapping("guest/{userId}")
	public ResponseEntity<List<Event>> findByGuest(@PathVariable("userId") int id) {
		List<Event> events = es.findByGuest(id);
		if (events == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(events);
	}
//	
//	@GetMapping("/upcoming")
//	public ResponseEntity<List<Event>> findUpcomingEvents(Date date) {
//		List<Event> events = es.findUpcoming(date);
//		if (events == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(events);
//	}
//	
//	@GetMapping("/past")
//	public ResponseEntity<List<Event>> findPastEvents(Date date) {
//		List<Event> events = es.findPast(date);
//		if (events == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(events);
//	}
//	
	@PostMapping
	public ResponseEntity<List<Event>> addEvent(@RequestBody Event ev) {
		es.addEvent(ev);
		return ResponseEntity.status(HttpStatus.OK).body(es.findAll());
	}
	
	@PutMapping
	public ResponseEntity<List<Event>> updateEvent(@RequestBody Event ev) {
		 es.updateEvent(ev);
		 return ResponseEntity.status(HttpStatus.OK).body(es.findAll());
	}
	
}