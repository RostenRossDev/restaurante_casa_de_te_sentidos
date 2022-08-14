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
}
