package com.darby.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.darby.models.Lease;
import com.darby.models.LeaseDTO;
import com.darby.models.MaintenanceTicket;
import com.darby.models.TicketDTO;
import com.darby.models.User;
import com.darby.services.TicketServices;




@RestController
@RequestMapping(value = "/ticket")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {

	TicketServices ts;
	
	@Autowired
	public TicketController(TicketServices ts) {
		super();
		this.ts = ts;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<MaintenanceTicket> getAll() {
		return ts.getAll();
	}

//	@GetMapping("/status")
//	public ResponseEntity<List<MaintenanceTicket>> findByStatus(@PathVariable("status") String status) {
//		List<MaintenanceTicket> a = ts.findByStatus(status);
//		if (a == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
//	}
//	
//	@GetMapping("/id")
//	public ResponseEntity<MaintenanceTicket> findById(@PathVariable("id") int id) {
//		MaintenanceTicket t = ts.findById(id);
//		if(t != null) {
//			return ResponseEntity.status(HttpStatus.OK).body(t);
//		} else {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		
//	}
	
	@GetMapping("{userId}")
	public ResponseEntity<List<MaintenanceTicket>> findByAuthor1(@PathVariable("userId") int ID) {
		System.out.println(ID);
		List<MaintenanceTicket> a = ts.findByAuthor1(ID);
		if (a == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	

	
	@PostMapping
	public ResponseEntity<List<MaintenanceTicket>> addTicket(@RequestBody MaintenanceTicket t) {
		ts.addTicket(t);
		System.out.println(t);
		return ResponseEntity.status(HttpStatus.OK).body(ts.getAll());
	}
	
	@PostMapping("update")
	public ResponseEntity<Boolean> updateTicket(@RequestBody TicketDTO l) {
		MaintenanceTicket ticket = ts.updateTicket(l);
		if((ticket) == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
	}
	
}