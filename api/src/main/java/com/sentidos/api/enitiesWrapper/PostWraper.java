package com.sentidos.api.enitiesWrapper;

import com.sentidos.api.dto.PostDto;
import com.sentidos.api.entities.Post;

public class PostWraper {

	public static Post dtoToEntity(PostDto postDto) {
		Post post = new Post();
		post.setComment(postDto.getComment());
		post.setCreateAt(postDto.getCreateAt());
		return post;
	}
	public static PostDto entityToDto(Post post) {
		PostDto dto = new PostDto();
		dto.setComment(post.getComment());
		dto.setCreateAt(post.getCreateDate());
		dto.setUser(post.getCustomer().getUser().getUsername());
		return dto;
	}
}
