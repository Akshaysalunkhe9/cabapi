package com.codegram.cabapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.codegram.cabapi.service.AdminService;
import com.codegram.cabapi.service.CabService;
import com.codegram.cabapi.service.CustomerService;
import com.codegram.cabapi.service.DriverService;
import com.codegram.cabapi.service.OperatorService;
import com.codegram.cabapi.service.TripBookingService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	JwtAuthenticationFilter jwtFilter;
	
	@Autowired
	AdminService adminService;
	@Autowired
	CabService cabService;
	@Autowired
	CustomerService customerService;
	@Autowired
	DriverService driverService;
	@Autowired
	OperatorService operatorService;
	@Autowired
	TripBookingService tripBookingService;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
					.csrf()
					.disable()
					.cors()
					.disable()
					.authorizeRequests()
					.antMatchers("/api/token").permitAll()
					.antMatchers("/api/admins/**").authenticated()
//					.anyRequest().authenticated()
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(adminService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


}
