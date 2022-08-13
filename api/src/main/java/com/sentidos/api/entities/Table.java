package com.sentidos.api.entities;

public class Table {

	private Long id;
	private Integer number;
	private Boolean isReserved;
	
	public Table(Long id, Integer number, Boolean isReserved) {
		super();
		this.id = id;
		this.number = number;
		this.isReserved = isReserved;
	}

	public Table() {
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

	public Boolean getIsReserved() {
		return isReserved;
	}

	public void setIsReserved(Boolean isReserved) {
		this.isReserved = isReserved;
	}
	

}
