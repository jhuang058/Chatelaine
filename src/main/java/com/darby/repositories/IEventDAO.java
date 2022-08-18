package com.darby.repositories;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darby.models.Event;

public interface IEventDAO  extends JpaRepository<Event, Integer> {

	List<Event> findByEventDate(Date date);


//	List<Event> findUpcoming(Date date);
//	List<Event> findPast(Date date);


	List<Event> findByEventCreator(int id);
	List<Event> findByUserList_userID(int id);
		
	
}
	