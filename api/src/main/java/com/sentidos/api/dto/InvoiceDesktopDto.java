package com.sentidos.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceDesktopDto {
	private Long id;
	private String usuario;
	private Boolean pagado;
	private List<InvoiceDetailDto> invoicesDetail= new ArrayList<>();
	private String metodoPago;
	private Date fechaPago;
    private Date createAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public Boolean getPagado() {
		return pagado;
	}
	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public List<InvoiceDetailDto> getInvoicesDetail() {
		return invoicesDetail;
	}
	public void setInvoicesDetail(List<InvoiceDetailDto> invoicesDto) {
		this.invoicesDetail = invoicesDto;
	}
	public InvoiceDesktopDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InvoiceDesktopDto [id=" + id + ", usuario=" + usuario + ", pagado=" + pagado
				+ ", invoicesDto=" + invoicesDetail + ", metodoPago=" + metodoPago + ", fechaPago=" + fechaPago
				+ ", createAt=" + createAt + "]";
	}
	  
    
}
