package com.jcastillo.exchanger.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;
@Component
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        writer.println("Logout success - " + authentication.getPrincipal());
		
		
		super.onLogoutSuccess(request, response, authentication);
	}
	

}
