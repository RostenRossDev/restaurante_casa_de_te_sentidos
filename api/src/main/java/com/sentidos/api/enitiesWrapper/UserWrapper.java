package com.sentidos.api.enitiesWrapper;

import com.sentidos.api.dto.PostDto;
import com.sentidos.api.dto.UserDto;
import com.sentidos.api.entities.Post;
import com.sentidos.api.entities.User;

public class UserWrapper {
	public static User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEnabled(Boolean.TRUE);
		return user;
	}
	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setEnabled(user.getEnabled());
		return userDto;
	}
}
