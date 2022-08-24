package com.sentidos.api.dto;

import java.util.Date;

public class ReservationDto {

	private Integer table;
	private Date dateReservation;
	private String username;
	
	public Integer getTable() {
		return table;
	}
	public void setTable(Integer table) {
		this.table = table;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
