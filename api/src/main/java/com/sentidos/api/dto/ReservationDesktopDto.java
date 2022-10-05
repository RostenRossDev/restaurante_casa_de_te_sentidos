package com.sentidos.api.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationDesktopDto {
	private Logger log = LoggerFactory.getLogger(ReservationDesktopDto.class);
	private Integer table;
	private Long id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateReservation;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_at;
	private String username;
	private String dateReservationString;
	private Boolean confirmed;
	private Boolean isTea;
	private Boolean hour;
	private Boolean disabled;
	private String location;
	
	public Integer getTable() {
		return table;
	}
	public void setTable(Integer table) {
		this.table = table;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	
    
	public String getDateReservationString() {
		return dateReservationString;
	}

	public void setDateReservation(Date dateReservation) {
		log.info(dateReservation.toString());
		Date date = new Date((dateReservation.getYear()), (dateReservation.getMonth()), dateReservation.getDate());
		log.info(date.toString());

		this.dateReservation = date;
		log.info((dateReservation.getYear()+1900)+"-"+"0"+(dateReservation.getMonth())+"-"+dateReservation.getDate());
		this.dateReservationString=(dateReservation.getYear()+1900) +"-"+(dateReservation.getMonth()+1)+"-"+dateReservation.getDate();
	    log.info("resrevation date strin: "+dateReservationString);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	
	
	public Boolean getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	public void setDateReservationString(String dateReservationString) {
		this.dateReservationString = dateReservationString;
	}	
	
	public Boolean getIsTea() {
		return isTea;
	}
	public void setIsTea(Boolean isTea) {
		this.isTea = isTea;
	}
	public Boolean getHour() {
		return hour;
	}
	public void setHour(Boolean hour) {
		this.hour = hour;
	}
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ReservationDto [log=" + log + ", table=" + table + ", dateReservation=" + dateReservation
				+ ", create_at=" + create_at + ", username=" + username + ", dateReservationString="
				+ dateReservationString + ", confirmed=" + confirmed + ", isTea=" + isTea + ", hour=" + hour
				+ ", disabled=" + disabled + ", location=" + location + "]";
	}
	
	
}
