package com.sentidos.api.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sentidos.api.entities.User;

public interface IUserDao extends CrudRepository<User, Long>{

	public User findByUsername(String username); 
	
	public Optional<User> findById(Long id); 
}
