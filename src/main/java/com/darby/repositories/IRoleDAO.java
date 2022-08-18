package com.darby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darby.models.Role;

public interface IRoleDAO  extends JpaRepository<Role, Integer> {

	public Role findRoleByRoleID(int roleId);
	
	public Role findRoleByRole(String role);
}
