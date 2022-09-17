package com.sentidos.api.enitiesWrapper;

import java.util.ArrayList;
import java.util.List;

import com.sentidos.api.dto.InvoiceDetailDto;
import com.sentidos.api.dto.MenuDto;
import com.sentidos.api.dto.OrderDto;
import com.sentidos.api.entities.InvoiceDetail;
import com.sentidos.api.entities.Menu;
import com.sentidos.api.entities.Order;
import com.sentidos.api.entities.OrderDetail;

public class MenuWrapper {
	
	public static Menu dtoToEntity(MenuDto dto) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		List<InvoiceDetail> invoiceDetails = new ArrayList<>();
		
		dto.getOdrdersDetailDto().forEach(item -> {
			orderDetails.add(OrderDetailWrapper.dtoToEntity(item));
		});
		
		dto.getInvoiceDetailDto().forEach(item ->{
			//invoiceDetails.add(Inv)
		});
		
		Menu menu = new Menu();
		menu.setIsEnabled(dto.getIsEnabled());
		menu.setPrice(dto.getPrice());
		menu.setName(dto.getName());
		menu.setOrderDetails(orderDetails);
		//menu.setInvoiceDetails(invoiceDetails);
		return menu;
	}
	
	
	public static MenuDto entityToDto(Menu menu) {
		MenuDto dto= new MenuDto();
		dto.setMenuType(menu.getMenuType().getType());
		dto.setName(menu.getName());
		dto.setPrice(menu.getPrice());
		return dto;
	}
}
