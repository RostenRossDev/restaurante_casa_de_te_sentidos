package com.sentidos.api.entities;

public class Invoice {

	private Long id;
	private Customer customer;
	private Invoice invoice;
	public Invoice(Long id, Customer customer, Invoice invoice) {
		super();
		this.id = id;
		this.customer = customer;
		this.invoice = invoice;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}	
}
