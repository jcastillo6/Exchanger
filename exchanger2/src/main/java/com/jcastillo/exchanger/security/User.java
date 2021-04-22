package com.jcastillo.exchanger.security;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/exchanges")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*", maxAge=3600)
public class User {
	
	  @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }

}
