package com.darby.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.darby.repositories.ILeaseDAO;

import com.darby.models.Lease;
import com.darby.models.LeaseDTO;
import com.darby.models.User;

@Service
public class LeaseServices {
	
	private ILeaseDAO lDAO;
	
	@Autowired
	public LeaseServices(ILeaseDAO lDAO) {
		super();
		this.lDAO = lDAO;
	}



	public Lease findLeaseByTenant(int id) {
		return lDAO.findByUserUserID(id);
	}

	public List<Lease> findAll(String status) {
		if(status.equals("all")){
			return lDAO.findAllByOrderByTenantSigDateDesc();
		}else if(status.equals("signed")) {
			
			return lDAO.findByLandlordSigOrderByTenantSigDateDesc(true);
		}else {
			return lDAO.findByLandlordSigOrderByTenantSigDateDesc(false);
		}
	}



	public Lease updateLease(LeaseDTO l) {
		Lease lease = findById(l.leaseID);

			Calendar endDate = Calendar.getInstance();
			endDate.add(Calendar.YEAR, 1);
			Timestamp timestamp = new Timestamp(new Date().getTime());
			if (l.party.equals("tenant")) {
				lease.setLandlordSig(false);
				lease.setLandlordSigDate(null);
				lease.setStartDate(timestamp);
				lease.setTenantSigDate(timestamp);
				lease.setEndDate(new Timestamp(endDate.getTimeInMillis()));
			} else if (l.party.equals("landlord")) {
				lease.setLandlordSig(true);
				lease.setLandlordSigDate(new Timestamp(new Date().getTime()));
			}

		
	 return lDAO.save(lease);
	}



	public Lease findById(int leaseID) {
		return lDAO.findByLeaseID(leaseID);
	}



	public Lease newLease(User tenant) {
		Timestamp today = new Timestamp(new Date().getTime());
		Calendar endDate =Calendar.getInstance();
		endDate.add(Calendar.YEAR, 1);
		Lease lease = new Lease(today, new Timestamp(endDate.getTimeInMillis()), false, true, null, today, tenant);
		return lDAO.save(lease);
	}
	
	public Lease uploadLease(Lease l) {
		return lDAO.save(l);
	}

}