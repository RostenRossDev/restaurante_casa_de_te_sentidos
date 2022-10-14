package com.sentidos.api.dto;


public class OrderDetailDesktopDto {
	
	private int quantity;
	private String name;	
	private Double price;	
	private String menuType;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public OrderDetailDesktopDto(int quantity, MenuDto menuDto) {
		super();
		this.quantity = quantity;
	}
	public OrderDetailDesktopDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
