package com.sentidos.api.services;

import java.util.List;

import com.sentidos.api.entities.Post;

public interface IPostService {
	public List<Post> findAll();
	public Post save(Post post);
	public void deleteById(Long id);
}
