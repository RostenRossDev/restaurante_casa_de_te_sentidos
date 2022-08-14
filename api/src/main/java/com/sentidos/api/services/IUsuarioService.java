package com.sentidos.api.services;

import com.sentidos.api.entities.User;

public interface IUsuarioService {
	public User findByUsername(String username);
	
	public User save(User user);
}
