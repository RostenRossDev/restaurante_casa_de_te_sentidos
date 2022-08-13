package com.sentidos.api.entities;

public class InvoiceDetail {

	private Long id;
	private Integer Quantity;
	private Menu menu;
	public InvoiceDetail(Long id, Integer quantity, Menu menu) {
		super();
		this.id = id;
		Quantity = quantity;
		this.menu = menu;
	}
	public InvoiceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
