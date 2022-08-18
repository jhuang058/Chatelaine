package com.darby;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.darby.services.EventServices;
import com.darby.services.LeaseServices;
import com.darby.models.Event;
import com.darby.models.Lease;

import org.junit.AfterClass;
import org.junit.BeforeClass;

@SpringBootTest
public class LeaseServiceTests {
	
	@Autowired 
	public LeaseServices ls; //change to constructor injection
	
	public static int userId;
	public static int leaseID;
	public static String status;
	
	@BeforeClass
	public static void initialize() {
		userId = 9;
		leaseID = 1;
		status = "signed";
	}
	
	
	@Test
	public void findAll() {
		List<Lease> eList= ls.findAll("signed");
		assertTrue(eList!=null);
	}
	
	@Test
	public void findByTenant() {
		Lease eList= ls.findLeaseByTenant(9);
		assertTrue(eList!=null);
	}
	
	@Test
	public void findById() {
		Lease l = ls.findById(1);
		assertTrue(l!=null);
	}
		

}
