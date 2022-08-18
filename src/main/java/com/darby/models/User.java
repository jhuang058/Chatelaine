package com.darby.models;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id", nullable=false)
	private int userID;
	@Column(name="username", nullable=false, unique=true)
	private String username;
	@Column(name="password", nullable=false)
	private String password;
	@Column(name="first_name", nullable=false)
	private String firstName;
	@Column(name="last_name", nullable=false)
	private String lastName;
	@Column(name="phone_number", nullable=false, unique=true)
	private String phoneNumber;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_role_id", nullable=false)
	private Role userRole;
	@ManyToMany(mappedBy="userList", fetch=FetchType.EAGER)
	private List<Event> eventList;
//	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
//	@JsonManagedReference(value="user")//prevents infinite loops in my json
//	private List<MaintenanceTicket> tickets;
	
	public User() {
		super();
	}
	
//Constructor without id and eventList
	public User(String username, String password, String firstName, String lastName, String phoneNumber, Role userRole) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userRole = userRole;
	
	}



	public User(int userID, String username, String password, String firstName, String lastName, String phoneNumber,
			Role userRole, Blob signedLease, List<Event> eventList, List<MaintenanceTicket> tickets, List<Lease> leases) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userRole = userRole;
//		this.tickets = tickets;
//		this.leases = leases;
//		this.eventList = eventList;
	}


	public User(int userID, String username, String password, String firstName, String lastName, String phoneNumber,
		Role userRole) {
	super();
	this.userID = userID;
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
	this.userRole = userRole;
}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

//	public List<Lease> getLeases() {
//		return leases;
//	}
//
//	public void setLeases(List<Lease> leases) {
//		this.leases = leases;
//	}
//
//	public List<MaintenanceTicket> getTickets() {
//		return tickets;
//	}
//
//	public void setTickets(List<MaintenanceTicket> tickets) {
//		this.tickets = tickets;
//	}

//	public List<MaintenanceTicket> getTickets() {
//		return tickets;
//	}
//
//	public void setTickets(List<MaintenanceTicket> tickets) {
//		this.tickets = tickets;
//	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	

//	public List<Event> getEventList() {
//		return eventList;
//	}
//
//	public void setEventList(List<Event> eventList) {
//		this.eventList = eventList;
//	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((eventList == null) ? 0 : eventList.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + userID;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
//		if (eventList == null) {
//			if (other.eventList != null)
//				return false;
//		} else if (!eventList.equals(other.eventList))
//			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (userID != other.userID)
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", userRole=" + userRole
				+ "]";
	}
	
	

}
