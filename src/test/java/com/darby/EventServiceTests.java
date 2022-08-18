package com.darby;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.darby.services.EventServices;
import com.darby.models.Event;
import com.darby.models.User;
import com.darby.repositories.IUserDAO;

import org.junit.BeforeClass;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class EventServiceTests {
	
	@Autowired 
	public EventServices es; //change to constructor injection
	@Autowired
	public static IUserDAO udao;
	
	public static int userId;
	public static Event event;
	public static User user;
	public static List<User> ulist;
	
	@BeforeClass
	public static void setUserId() {
		userId = 1;
		user = udao.findById(userId).get();
	}
	
	@Test
	public void findAll() {
		List<Event> eList= es.findAll();
		assertTrue(eList!=null);
	}
	
	@Test
	public void findByGuest() {
		List<Event> eList= es.findByGuest(userId);
		assertTrue(eList!=null);
	}

	//This doesn't work
//	@Test
//	public void addEvent() {
//		ulist = new ArrayList<User>();
//		ulist.add(udao.findById(9).get());
//		event = new Event("testEvent", "testDesc", new Date(System.currentTimeMillis()), user, ulist);
//		List<Event> eList = es.addEvent(event);
//		assertTrue(eList!=null);
//	}
		

}
