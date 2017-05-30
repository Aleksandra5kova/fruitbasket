package com.aleksandra.dao;

import java.util.List;

import com.aleksandra.model.User;

public interface UserDao {

	public User findByUsername(String username);
	
	public User findByEmail(String email);

	public void persist(User user);

	public List<User> getUsers();
	
	public User getCurrentUser(String username);
	
}
