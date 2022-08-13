package com.sentidos.api.entities;

public class StreetName {

	private Long id;
	private String name;
	public StreetName(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public StreetName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
