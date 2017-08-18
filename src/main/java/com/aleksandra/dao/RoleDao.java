package com.aleksandra.dao;

import java.util.List;

import com.aleksandra.model.Role;

public interface RoleDao {

	public List<Role> getAll();
	
	public Role getRoleByDescription(String description);
	
}
