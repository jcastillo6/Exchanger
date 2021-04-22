package com.jcastillo.exchanger.security;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BasicAuthEntryPoint authenticationEntryPoint;
	@Autowired
	private CustomLogoutSuccessHandler customLogout;
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user1").password(passwordEncoder().encode("user1Pass"))
          .authorities("ROLE_USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	    	
    	http
        .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
        .and().authorizeRequests().antMatchers("/index.html", "/", "/home", "/login","/api/**").permitAll().anyRequest().authenticated()
          .and().logout().deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutSuccessHandler(customLogout).permitAll()
          .and().cors().configurationSource(request -> {
              var cors = new CorsConfiguration();
              cors.setAllowedOrigins(List.of("http://localhost:4200"));
              cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
              cors.setAllowedHeaders(List.of("*"));
              return cors;
            });
              
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
