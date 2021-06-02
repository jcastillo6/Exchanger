package com.jcastillo.crypto.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcastillo.crypto.model.AuthenticationResponse;
import com.jcastillo.crypto.model.User;
import com.jcastillo.crypto.security.DefaultUserDetailService;
import com.jcastillo.crypto.security.JwsUtil;

@RestController
@RequestMapping("/api/v1")
public class Access {
	
	@Autowired
	private AuthenticationManager am;
	
	@Autowired
	private DefaultUserDetailService duds;
	
	@Autowired
	private JwsUtil jwt;
	

	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody User user) throws Exception{
		
		try {
			var upt = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
			am.authenticate(upt);
		} catch (BadCredentialsException e) {

			throw new Exception("Incorrect user name or password",e);
			
		}
		
		var userDetails = duds.loadUserByUsername(user.getUserName());
		 
		
		return new AuthenticationResponse(jwt.generateToken(userDetails)); 
		
		
	}

}
