package com.aleksandra.service;

import java.util.List;

import com.aleksandra.model.User;

public interface UserService {

	public void save(User user);

	public User findByUsername(String username);
	
	public List<User> getUsers();
}
