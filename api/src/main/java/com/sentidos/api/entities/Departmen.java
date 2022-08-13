package com.sentidos.api.entities;

public class Departmen {

	private Long id;
	private String dpto;
	
	public Departmen(Long id, String dpto) {
		super();
		this.id = id;
		this.dpto = dpto;
	}

	public Departmen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}
	
	
}
