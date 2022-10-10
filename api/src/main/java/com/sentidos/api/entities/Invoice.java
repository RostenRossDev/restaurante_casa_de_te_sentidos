package com.sentidos.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="invoices")
public class Invoice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	@JoinColumn(name = "order_id")
    @OneToOne(fetch = FetchType.LAZY)
	private Order order;
	*/
	//@JsonIgnore
	@ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
	
    @OneToMany( mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InvoiceDetail> details;
	
	@Column(name = "create_at")
    private Date createAt;    
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "is_payment")
	private Boolean isPayment;
	
	@PrePersist
    public void prePersist() {
        createAt = new Date();
    }
	
	public void addInvoiceDetail(InvoiceDetail detail) {
		this.details.add(detail);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	/*
	 
	 public Order getOrder() {
	 
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	*/
	public List<InvoiceDetail> getDetails() {
		return details;
	}
	public void setDetails(List<InvoiceDetail> details) {
		this.details = details;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Boolean getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(Boolean isPayment) {
		this.isPayment = isPayment;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", customer=" + customer + ", details=" + details + ", createAt=" + createAt
				+ ", paymentMethod=" + paymentMethod + ", paymentDate=" + paymentDate + ", isPayment=" + isPayment
				+ "]";
	}
	
}
