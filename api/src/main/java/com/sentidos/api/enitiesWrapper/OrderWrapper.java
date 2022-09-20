package com.sentidos.api.enitiesWrapper;

import java.util.ArrayList;
import java.util.List;

import com.sentidos.api.dto.OrderDetailDto;
import com.sentidos.api.dto.OrderDto;
import com.sentidos.api.entities.Order;

public class OrderWrapper {

	public static Order dtoToEntity(OrderDto dto) {
		Order order = new Order();
		order.setCustomer(CustomerWrapper.dtoToEntity(dto.getCustomerDto()));		
		order.setState(dto.getState());
		order.setCreateAt(dto.getCreateAt());
		order.setIsDelivered(dto.getIsDelivered());
		return order;
	}
	
	
	public static OrderDto entityToDto(Order order) {
		List<OrderDetailDto> orderDetailsDto = new ArrayList<OrderDetailDto>();
		
		order.getOrderDetails().forEach(item -> {
			orderDetailsDto.add(OrderDetailWrapper.entityToDto(item));
		});
		
		OrderDto dto= new OrderDto();
		dto.setCreateAt(order.getCreateAt());
		dto.setCustomerDto(CustomerWrapper.entityToDto(order.getCustomer()));
		dto.setIsDelivered(order.getIsDelivered());
		dto.setState(order.getState());
		dto.setOrderDetails(orderDetailsDto);
		return dto;
	}
}
