package com.sentidos.api.enitiesWrapper;

import com.sentidos.api.dto.PostDto;
import com.sentidos.api.entities.Post;

public class PostWraper {

	public static Post dtoToEntity(PostDto dto) {
		Post post = new Post();
		post.setComment(dto.getComment());
		post.setCreateAt(dto.getCreateAt());
		return post;
	}
	public static PostDto entityToDto(Post entity) {
		PostDto dto = new PostDto();
		dto.setComment(entity.getComment());
		dto.setCreateAt(entity.getCreateDate());
		dto.setUser(entity.getCustomer().getUser().getUsername());
		return dto;
	}
}
