package com.sentidos.api.enitiesWrapper;

import com.sentidos.api.dto.OrderDetailDto;
import com.sentidos.api.dto.OrderDto;
import com.sentidos.api.entities.Order;
import com.sentidos.api.entities.OrderDetail;

public class OrderDetailWrapper {

	public static OrderDetail dtoToEntity(OrderDetailDto dto) {
		OrderDetail order = new OrderDetail();
		
		return order;
	}
	
	
	public static OrderDetailDto entityToDto(OrderDetail order) {
		OrderDetailDto dto= new OrderDetailDto();
		dto.setMenuDto(MenuWrapper.entityToDto(order.getMenu()));
		dto.setQuantity(order.getQuantity());
		return dto;
	}
}
