package com.aleksandra.service;

import com.aleksandra.model.User;

public interface UserService {

	public void save(User user);

	public User findByUsername(String username);
}
