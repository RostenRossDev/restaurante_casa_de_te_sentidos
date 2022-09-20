package com.sentidos.api.dto;

import com.sentidos.api.entities.Invoice;
import com.sentidos.api.entities.Menu;

public class InvoiceDetailDto {

	private Integer quantity;
	
	private InvoiceDto invoice;
	
	private MenuDto menu;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public InvoiceDto getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceDto invoice) {
		this.invoice = invoice;
	}

	public MenuDto getMenu() {
		return menu;
	}

	public void setMenu(MenuDto menu) {
		this.menu = menu;
	}	
	
}
