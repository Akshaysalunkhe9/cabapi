package com.codegram.cabapi.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.codegram.cabapi.config.helper.JwtUtil;
import com.codegram.cabapi.service.AdminService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//get jwt
		// starts with bearer or not
		// validate
		
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			UserDetails userDetails = this.adminService.loadUserByUsername(username);
			//security validate
			if(username != null && SecurityContextHolder.getContext().getAuthentication() != null) {
				
				UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
			}
			else {
				System.out.println("Token is not validated.");
			}
		}
		filterChain.doFilter(request, response);
		
		
	}
	

}
