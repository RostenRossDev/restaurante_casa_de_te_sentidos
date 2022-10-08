package com.sentidos.api.dto;

import java.util.Date;

public class ReservationDesktop {

	private Long id;
	private Integer table;
    private Date fecha;
    private String username;
    private Boolean confirmado;
    private Boolean isTea;
    private Boolean hora;
    
    
    
	public ReservationDesktop(Long id, Integer table, Date fecha, String username, Boolean confirmado, Boolean isTea,
			Boolean hora) {
		super();
		this.id = id;
		this.table = table;
		this.fecha = fecha;
		this.username = username;
		this.confirmado = confirmado;
		this.isTea = isTea;
		this.hora = hora;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTable() {
		return table;
	}
	public void setTable(Integer table) {
		this.table = table;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	public Boolean getIsTea() {
		return isTea;
	}
	public void setIsTea(Boolean isTea) {
		this.isTea = isTea;
	}
	public Boolean getHora() {
		return hora;
	}
	public void setHora(Boolean hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "ReservationDesktop [id=" + id + ", table=" + table + ", fecha=" + fecha + ", username=" + username
				+ ", confirmado=" + confirmado + ", isTea=" + isTea + ", hora=" + hora + "]";
	}    
           
    
	
}
