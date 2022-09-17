package com.sentidos.api.dto;

import java.util.List;

public class MenuDto {
	
	private String name;
	
	private Double price;
	
	private String menuType;
	
	private Boolean isEnabled;
	
	private List<OrderDetailDto> odrdersDetailDto;
	
	private List<InvoiceDetailDto> invoiceDetailDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<OrderDetailDto> getOdrdersDetailDto() {
		return odrdersDetailDto;
	}

	public void setOdrdersDetailDto(List<OrderDetailDto> odrdersDetailDto) {
		this.odrdersDetailDto = odrdersDetailDto;
	}

	public List<InvoiceDetailDto> getInvoiceDetailDto() {
		return invoiceDetailDto;
	}

	public void setInvoiceDetailDto(List<InvoiceDetailDto> invoiceDetailDto) {
		this.invoiceDetailDto = invoiceDetailDto;
	}    

	
}
