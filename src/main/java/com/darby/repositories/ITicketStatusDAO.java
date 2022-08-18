package com.darby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darby.models.TicketStatus;

public interface ITicketStatusDAO extends JpaRepository<TicketStatus, Integer> {
	
	TicketStatus findByStatusId(int id);

	TicketStatus findByStatus(String status);

}
