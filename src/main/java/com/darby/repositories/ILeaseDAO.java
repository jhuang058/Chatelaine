package com.darby.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darby.models.Lease;

public interface ILeaseDAO  extends JpaRepository<Lease, Integer> {

	List<Lease> findAllByOrderByTenantSigDateDesc();
	Lease findByUserUserID(int id);

	Lease findByLeaseID(int id);

	List<Lease> findByLandlordSigOrderByTenantSigDateDesc(boolean signed);
}
