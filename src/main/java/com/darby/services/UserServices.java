package com.darby.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darby.repositories.IUserDAO;
import com.darby.models.Role;
import com.darby.models.User;
import com.darby.models.UserDTO;
import com.darby.utils.Hash;

@Service
public class UserServices {

	
	private IUserDAO userDAO;
	
//	@Autowired
	private RoleService roleService;
	
	private LeaseServices leaseService;
//	
	@Autowired
	public UserServices(IUserDAO userDAO, RoleService roleService, LeaseServices leaseService) {
		super();
		this.userDAO = userDAO;
		this.roleService = roleService;
		this.leaseService = leaseService;
	}

	public Optional<User> findById(int id) {
		return userDAO.findById(id);
		
	}
	public List<User> findAll(){
		return userDAO.findAll();
		
	}

	public Role findUserRole(int id) {
		Role role = roleService.findById(id);
		return role;
		
	}

	public User updateUser(User p) {
		return userDAO.save(p);
	}


	public User login(String username, String password) {
		String hashedPassword = "";
		try {
			hashedPassword = Hash.generateHash(password, "MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return userDAO.findUserByUsernameAndPassword(username.toLowerCase(), hashedPassword);
	}


	public User addUser(UserDTO p) {
		String password = "";
		try {
			password = Hash.generateHash(p.password, "MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Role userRole = roleService.findByName("Tenant");
		User user = new User(p.username.toLowerCase(), password, p.firstName, p.lastName, p.phoneNumber, userRole);
		userDAO.save(user);
		leaseService.newLease(user);
		return user;
	}
	
}