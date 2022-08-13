package com.sentidos.api.entities;

import java.sql.Date;

public class Post {

	private Long id;
	private String comment;
	private Date createDate;
	public Post(Long id, String comment, Date createDate) {
		super();
		this.id = id;
		this.comment = comment;
		this.createDate = createDate;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
