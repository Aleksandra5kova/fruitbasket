package com.aleksandra.configuration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		UserDetails user = userDetailsService.loadUserByUsername(username);

		if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
			System.out.println("username not found");
			return null;
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(password, user.getPassword())) {
			System.out.println("wrong password");
			return null;
		}

		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

		return new UsernamePasswordAuthenticationToken(user, password, authorities);

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
