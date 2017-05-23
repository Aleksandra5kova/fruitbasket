package com.aleksandra.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.UserDao;
import com.aleksandra.model.Role;
import com.aleksandra.model.User;
import com.aleksandra.model.UserPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Unknown User");
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getDescription()));
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNotExpired = true;
		boolean accountNonLocked = true;
		UserPrincipal principal = new UserPrincipal(user, enabled, accountNonExpired, credentialsNotExpired,
				accountNonLocked, grantedAuthorities);
		return principal;
		
	}

}
