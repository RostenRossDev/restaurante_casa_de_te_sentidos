package com.sentidos.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	  @Bean
      public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/locale", "/api/v1/login","/api/v1/post").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin().permitAll()
          .and()
          .logout().permitAll();
          
          return http.build();
      }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService()throws Exception{
				
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User
	            .withUsername("user")
	            .password(passwordEncoder().encode("user"))
	            .roles("USER")
	            .build());
		 manager.createUser(User
		            .withUsername("admin")
		            .password(passwordEncoder().encode("admin"))
		            .roles("ADMIN","USER")
		            .build());
		
		return manager;
	}
}
