package com.sentidos.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice_details")
public class InvoiceDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer Quantity;
	
	@ManyToOne()
    @JoinColumn(name = "invoice_id")
	private Invoice invoice;
	//private Menu menu;
	
	public InvoiceDetail(Long id, Integer quantity, Menu menu) {
		super();
		this.id = id;
		Quantity = quantity;
		//this.menu = menu;
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
	
	/*public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	*/
}
