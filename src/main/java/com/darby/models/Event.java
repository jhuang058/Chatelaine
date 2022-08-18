package com.darby.models;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@Component
@Entity
@Table(name="events")
public class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id", nullable=false)
	private int eventID;
	@Column(name="event_name", nullable=false)
	private String eventName;
	@Column(name="event_description")
	private String eventDescription;
	@Column(name="event_date", nullable=false)
	private Date eventDate;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	private User eventCreator;
	@ManyToMany
	@JoinTable(
			  name = "event_user", 
			  joinColumns = @JoinColumn(name = "event_id"), 
			  inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> userList = new ArrayList<User>();
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Constructor without id and userList
	public Event(String eventName, String eventDescription, Date eventDate, User creator) {
		super();
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.eventCreator = creator;
	}
	
	
	public Event(int eventID, String eventName, String eventDescription, Date eventDate, User eventCreator) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.eventCreator = eventCreator;
	}

	public Event(String eventName, String eventDescription, Date eventDate, User creator, List<User> userList) {
		super();
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.eventCreator = creator;
		this.userList = userList;
	}

	public Event(int eventID, String eventName, String eventDescription, Date eventDate, User creator,
			List<User> userList) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.eventCreator = creator;
		this.userList = userList;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getEventCreator() {
		return eventCreator;
	}

	public void setEventCreator(User creator) {
		this.eventCreator = creator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventCreator == null) ? 0 : eventCreator.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventDescription == null) ? 0 : eventDescription.hashCode());
		result = prime * result + eventID;
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((userList == null) ? 0 : userList.hashCode());
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
		Event other = (Event) obj;
		if (eventCreator == null) {
			if (other.eventCreator != null)
				return false;
		} else if (!eventCreator.equals(other.eventCreator))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventDescription == null) {
			if (other.eventDescription != null)
				return false;
		} else if (!eventDescription.equals(other.eventDescription))
			return false;
		if (eventID != other.eventID)
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (userList == null) {
			if (other.userList != null)
				return false;
		} else if (!userList.equals(other.userList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [eventID=" + eventID + ", eventName=" + eventName + ", eventDescription=" + eventDescription
				+ ", eventDate=" + eventDate + ", eventCreator=" + eventCreator + ", userList=" + userList + "]";
	}

	
}
