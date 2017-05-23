package com.aleksandra.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class UserPrincipal extends org.springframework.security.core.userdetails.User {

	private final User user;

	public UserPrincipal(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), authorities);
		this.user = user;
	}

	public UserPrincipal(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
