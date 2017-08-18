package com.aleksandra.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.RoleDao;
import com.aleksandra.dao.UserDao;
import com.aleksandra.model.Role;
import com.aleksandra.model.User;
import com.aleksandra.service.SecurityService;
import com.aleksandra.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleDao.getRoleByDescription("ROLE_USER"));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roles);
		userDao.persist(user);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User getCurrentUser() {
		String loggedInUsername = securityService.findLoggedInUsername();
		User user = userDao.getCurrentUser(loggedInUsername); 
		List<Role> roles = user.getRoles();
		return user;
	}

}
