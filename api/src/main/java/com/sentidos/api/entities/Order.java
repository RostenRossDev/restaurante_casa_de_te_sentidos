package com.sentidos.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@Column(name = "create_at")
	private Date createAt;
    
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}	
	
}
