package com.sentidos.api.enitiesWrapper;

import com.sentidos.api.dto.InvoiceDetailDto;
import com.sentidos.api.dto.InvoiceDto;
import com.sentidos.api.entities.Invoice;
import com.sentidos.api.entities.InvoiceDetail;

public class InvoiceWrapper {

	public static Invoice dtoToEntity(InvoiceDto dto) {			
		Invoice invoice = new Invoice();
		
		
		return invoice;
	}
	
	
	public static InvoiceDto entityToDto(Invoice invoice) {
		InvoiceDto dto= new InvoiceDto();
		
		return dto;
	}
}
