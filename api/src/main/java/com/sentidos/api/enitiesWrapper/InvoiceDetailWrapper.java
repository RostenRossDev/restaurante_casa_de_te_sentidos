package com.sentidos.api.enitiesWrapper;

import java.util.ArrayList;
import java.util.List;

import com.sentidos.api.dto.InvoiceDetailDto;
import com.sentidos.api.dto.MenuDto;
import com.sentidos.api.entities.InvoiceDetail;
import com.sentidos.api.entities.Menu;
import com.sentidos.api.entities.OrderDetail;

public class InvoiceDetailWrapper {

	public static InvoiceDetail dtoToEntity(InvoiceDetailDto dto) {			
		InvoiceDetail invoice = new InvoiceDetail();
		//invoice.setInvoice(Invo.dtoToEntity(dto.getInvoice()));
		invoice.setMenu(MenuWrapper.dtoToEntity(dto.getMenu()));
		invoice.setQuantity(dto.getQuantity());
		return invoice;
	}
	
	
	public static InvoiceDetailDto entityToDto(InvoiceDetail menu) {
		InvoiceDetailDto dto= new InvoiceDetailDto();
		
		return dto;
	}
}
