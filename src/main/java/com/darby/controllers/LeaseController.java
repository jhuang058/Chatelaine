package com.darby.controllers;

import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.darby.models.Lease;
import com.darby.models.LeaseDTO;

import com.darby.models.User;

import com.darby.services.LeaseServices;


@RestController
@RequestMapping(value = "/lease")
@ResponseBody
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LeaseController {

	private LeaseServices lServices;
	private HttpSession sesh;
	private UserController uc;
	

	@Autowired
	public LeaseController(LeaseServices lServices, HttpSession sesh, UserController uc) {
		super();
		this.lServices = lServices;
		this.sesh = sesh;
		this.uc = uc;

	}

	@GetMapping("allLeases/{status}")
	public List<Lease> getAllLease(@PathVariable("status") String status) {
		return lServices.findAll(status);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Lease> findLeaseByTenant(@PathVariable int id) {
		Lease a = lServices.findLeaseByTenant(id);
		if (a == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(a);
	}
	
	@RequestMapping(value=("/upload"),method=RequestMethod.POST)
	public ResponseEntity<Boolean> uploadLease(@RequestParam("file") MultipartFile f) {
		if (f != null) {
			User u = uc.getU();

			Lease lease = lServices.findLeaseByTenant(u.getUserID());
			
			try {
				lease.setLeaseFile(f.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (lServices.uploadLease(lease) == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	

	@PostMapping("update")
	public ResponseEntity<Boolean> updateLease(@RequestBody LeaseDTO l) {
		Lease lease = lServices.updateLease(l);
		if (lease == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}

}
