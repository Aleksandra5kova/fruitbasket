package com.aleksandra.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers(HttpMethod.GET, "/**").permitAll()
				.antMatchers("/users").permitAll()
			.anyRequest().authenticated()
			
			/*	.antMatchers("/authenticate").permitAll()
			.anyRequest().authenticated()*/
			
				.and()
				
				
			/*.formLogin().permitAll()
				.and()*/
				
			/*.logout()
				.permitAll()
				.and()*/
		    .httpBasic().authenticationEntryPoint(getAuthenticationEntryPoint())
		    	.and()
		    	
		    .authorizeRequests()
		    	.antMatchers("/**").permitAll()
		    
		    .anyRequest().fullyAuthenticated()
		    
		    	.and()
		    	
		    .csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	 public CustomBasicAuthenticationEntryPoint getAuthenticationEntryPoint() {
	  return new CustomBasicAuthenticationEntryPoint();
	 }
	
}
