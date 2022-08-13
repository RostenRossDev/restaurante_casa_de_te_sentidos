package com.sentidos.api.entities;

import java.util.HashMap;

public class Order {

	private Customer customer;
	private StreetName streeName;
	private StreetNumber streetName;
	private Departmen department;
	private Floor floor;
	private HashMap<Menu, Integer> menuOrder;
	private Boolean isDelivered;
	private Invoice invoice;
	public Order(Customer customer, StreetName streeName, StreetNumber streetName, Departmen department, Floor floor,
			HashMap<Menu, Integer> menuOrder, Boolean isDelivered, Invoice invoice) {
		super();
		this.customer = customer;
		this.streeName = streeName;
		this.streetName = streetName;
		this.department = department;
		this.floor = floor;
		this.menuOrder = menuOrder;
		this.isDelivered = isDelivered;
		this.invoice = invoice;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public StreetName getStreeName() {
		return streeName;
	}
	public void setStreeName(StreetName streeName) {
		this.streeName = streeName;
	}
	public StreetNumber getStreetName() {
		return streetName;
	}
	public void setStreetName(StreetNumber streetName) {
		this.streetName = streetName;
	}
	public Departmen getDepartment() {
		return department;
	}
	public void setDepartment(Departmen department) {
		this.department = department;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	public HashMap<Menu, Integer> getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(HashMap<Menu, Integer> menuOrder) {
		this.menuOrder = menuOrder;
	}
	public Boolean getIsDelivered() {
		return isDelivered;
	}
	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
