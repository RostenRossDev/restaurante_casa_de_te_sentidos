package com.sentidos.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.Post;

@Repository
public interface IPostDao extends CrudRepository<Post, Long>{
		
			
}