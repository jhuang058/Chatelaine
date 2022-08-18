package com.darby.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user_roles")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_role_id")
	private int roleID;
	@Column(name="user_role", nullable=false)
	private String role;


	public Role(String role) {
		super();
		this.role = role;
	}


	public Role(int roleID, String role) {
		super();
		this.roleID = roleID;
		this.role = role;
	}


	public Role() {
		super();
	}


	public int getRoleID() {
		return roleID;
	}


	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + roleID;
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
		Role other = (Role) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleID != other.roleID)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", role=" + role + "]";
	}
	
	

}
