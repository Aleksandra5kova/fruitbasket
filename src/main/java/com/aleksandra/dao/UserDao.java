package com.aleksandra.dao;

import com.aleksandra.model.User;

public interface UserDao {

	public User findByUsername(String username);

	public void persist(User user);
	
}
