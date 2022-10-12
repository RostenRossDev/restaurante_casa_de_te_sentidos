package com.sentidos.api.dto;

import java.util.Date;

public class InvoiceDesktopDto {
	private Long id;
	private Date fechaPago;
	private String username;
	private Boolean confirmado;
	private String metodoPago;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getConfirmado() {
		return confirmado;
	}
	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}	
	
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public InvoiceDesktopDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceDesktopDto(Long id, Date fechaPago, String username, Boolean confirmado, String metodoPago) {
		super();
		this.id = id;
		this.fechaPago = fechaPago;
		this.username = username;
		this.confirmado = confirmado;
		this.metodoPago = metodoPago;
	}
	@Override
	public String toString() {
		return "InvoiceDesktopDto [id=" + id + ", fechaPago=" + fechaPago + ", username=" + username + ", confirmado="
				+ confirmado + ", metodoPago=" + metodoPago + "]";
	}
	
}
