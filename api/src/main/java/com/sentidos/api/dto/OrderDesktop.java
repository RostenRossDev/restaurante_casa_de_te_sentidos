package com.sentidos.api.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDesktop {
	private List<Map<String, Integer>> orden;
	private Integer estado;
	private String username;
	private Integer mesa;
	private Boolean isDelivered;
	public  List<Map<String, Integer>> getOrden() {
		return orden;
	}
	public void setOrden(List<Map<String, Integer>> orden) {
		this.orden = orden;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getMesa() {
		return mesa;
	}
	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}
	
	public Boolean getIsDelivered() {
		return isDelivered;
	}
	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
		
	public OrderDesktop(List<Map<String, Integer>> orden, Integer estado, String username, Integer mesa,
			Boolean isDelivered) {
		super();
		this.orden = orden;
		this.estado = estado;
		this.username = username;
		this.mesa = mesa;
		this.isDelivered = isDelivered;
	}
	public OrderDesktop() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDesktop [orden=" + orden + ", estado=" + estado + ", username=" + username + ", mesa=" + mesa
				+ ", isDelivered=" + isDelivered + "]";
	}
	
}
