package com.sentidos.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservation  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne()
    @JoinColumn(name = "restaurantTable_id")
	private RestaurantTable restaurantTable;

	@ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
	
	private Date reservationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RestaurantTable getRestaurantTable() {
		return restaurantTable;
	}

	public void setRestaurantTable(RestaurantTable restaurantTable) {
		this.restaurantTable = restaurantTable;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	
}
