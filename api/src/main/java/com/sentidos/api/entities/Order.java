package com.sentidos.api.entities;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
	
	//private HashMap<Menu, Integer> menuOrder;
	private Boolean isDelivered;
	
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Invoice invoice;
	
	public Order(Customer customer, StreetName streeName, StreetNumber streetName, Departmen department, Floor floor,
			HashMap<Menu, Integer> menuOrder, Boolean isDelivered, Invoice invoice) {
		super();
		this.customer = customer;
		
		this.isDelivered = isDelivered;
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
	
	public Boolean getIsDelivered() {
		return isDelivered;
	}
	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}	
	
}
