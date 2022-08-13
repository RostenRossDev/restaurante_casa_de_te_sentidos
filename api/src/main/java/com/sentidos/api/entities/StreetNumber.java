package com.sentidos.api.entities;

public class StreetNumber {

	private Long id;
	private Integer number;
	public StreetNumber(Long id, Integer number) {
		super();
		this.id = id;
		this.number = number;
	}
	public StreetNumber() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
