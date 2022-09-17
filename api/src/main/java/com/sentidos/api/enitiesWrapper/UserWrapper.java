package com.sentidos.api.enitiesWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sentidos.api.auth.SpringSecurityConfig;
import com.sentidos.api.dto.UserDto;
import com.sentidos.api.entities.User;

public class UserWrapper {
	
	public static BCryptPasswordEncoder passwordEncoder = SpringSecurityConfig.passwordEncoder();
	
	public static User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode( userDto.getPassword()));
		user.setEnabled(Boolean.TRUE);
		return user;
	}
	
	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUsername(user.getUsername());	
		userDto.setEnabled(user.getEnabled());
		return userDto;
	}
}
