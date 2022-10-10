package com.sentidos.api.enitiesWrapper;

import com.sentidos.api.dto.InvoiceListDesktopDto;
import com.sentidos.api.dto.InvoiceDetailDto;
import com.sentidos.api.dto.InvoiceDto;
import com.sentidos.api.dto.MenuDto;
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
	
	public static InvoiceListDesktopDto entityToDtoDesktop(Invoice invoice) {
		InvoiceListDesktopDto dto = new InvoiceListDesktopDto();
		
		dto.setCreateAt(invoice.getCreateAt());
		dto.setFechaPago(invoice.getPaymentDate());
		dto.setId(invoice.getId());
		dto.setMetodoPago(invoice.getPaymentMethod());
		dto.setPagado(invoice.getIsPayment());
		dto.setUsuario(invoice.getCustomer().getUser().getUsername());
		
		for (InvoiceDetail id : invoice.getDetails()) {
			InvoiceDetailDto invDet = new InvoiceDetailDto();
			MenuDto menuDto = new MenuDto();
			menuDto.setName(id.getMenu().getName());
			menuDto.setPrice(id.getMenu().getPrice());
			menuDto.setMenuType(id.getMenu().getMenuType().getType());
			invDet.setMenu(menuDto);
			invDet.setQuantity(id.getQuantity());
			dto.getInvoicesDetail().add(invDet);
		}		
			
		
		return dto;
	}
}
