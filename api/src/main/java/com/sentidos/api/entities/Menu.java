package com.sentidos.api.entities;

public class Menu {
	private Long id;
	private String name;
	private Double price;
	private Boolean isEnabled;
	public Menu(Long id, String name, Double price, Boolean isEnabled) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isEnabled = isEnabled;
	}
	public Menu() {
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
}
