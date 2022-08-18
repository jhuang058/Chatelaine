package com.darby.services;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darby.repositories.ITicketDAO;
import com.darby.repositories.ITicketStatusDAO;
import com.darby.repositories.IUserDAO;
import com.darby.models.MaintenanceTicket;
import com.darby.models.TicketDTO;
import com.darby.models.TicketStatus;
import com.darby.models.User;

@Service
public class TicketServices {
	private static final Logger log = LogManager.getLogger(TicketServices.class);

	private ITicketDAO tdao;
	private ITicketStatusDAO tsdao;
	private IUserDAO udao;
	@Autowired
	public TicketServices(ITicketDAO tdao, ITicketStatusDAO tsdao, IUserDAO udao) {
		super();
		this.tdao = tdao;
		this.tsdao = tsdao;
		this.udao = udao;
	}
	
	public List<MaintenanceTicket> getAll() {
		log.info("Finding all Maintenance Tickets");
		return tdao.findAll();
	}
	
	public List<MaintenanceTicket> findByStatus(String status) {
		log.info("Finding Maintenance Ticket by Status");
		TicketStatus status1 = tsdao.findByStatus(status);
		return tdao.findByTicketId(status1.getStatusId());
	}
	
	@Transactional
	public MaintenanceTicket addTicket(MaintenanceTicket t) {
		log.info("Adding Maintenance Ticket");
		t.setStatusId(tsdao.findById(1).get());
		t.setSubmitted(new Timestamp(System.currentTimeMillis()));
		return tdao.save(t);
	}

	public MaintenanceTicket findById(int id) {
		log.info("Finding Maintenance Ticket by ID");
		return tdao.findById(id);
	}

	public MaintenanceTicket updateTicket(TicketDTO l) {
			log.info("Resolving Maintenance Ticket by ID");
			MaintenanceTicket ticket = findById(l.ticketId);
			Timestamp timestamp = new Timestamp(new Date().getTime());
			ticket.setResolved(timestamp);
			TicketStatus status = tsdao.findByStatusId(2);
			ticket.setStatusId(status);
		 return tdao.save(ticket);
	}

	public List<MaintenanceTicket> findByAuthor1(int ID) {
		log.info("Finding by author");
		User u = udao.getOne(ID);
		return tdao.findByAuthor(u);
	}

	
}