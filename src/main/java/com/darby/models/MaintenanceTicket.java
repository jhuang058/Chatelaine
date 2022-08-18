package com.darby.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table (name="maintenance_tickets")
public class MaintenanceTicket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int ticketId;
	@Column(name="description")
	private String description;
	@Column (nullable=false)
	private Timestamp submitted;
	@Column 
	private Timestamp resolved;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	//@JsonBackReference(value="user")
	private User author;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status_id", nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	//@JsonBackReference(value="status")
	private TicketStatus statusId;
	
	public MaintenanceTicket() {
		super();
	}
	
	
	public MaintenanceTicket(String description, User author) {
		super();
		this.description = description;
		this.author = author;
	}


	public MaintenanceTicket(int ticketId, String description, Timestamp submitted, Timestamp resolved, User author,
			TicketStatus statusId) {
		super();
		this.ticketId = ticketId;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.statusId = statusId;
	}

	public MaintenanceTicket(String description, Timestamp submitted, Timestamp resolved, User author,
			TicketStatus statusId) {
		super();
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.statusId = statusId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public TicketStatus getStatusId() {
		return statusId;
	}

	public void setStatusId(TicketStatus statusId) {
		this.statusId = statusId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + ticketId;
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
		MaintenanceTicket other = (MaintenanceTicket) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MaintenanceTicket [ticketId=" + ticketId + ", description=" + description + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", author=" + author + ", statusId=" + statusId + "]";
	}


	
	
	
	

}