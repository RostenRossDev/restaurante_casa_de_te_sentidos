package com.sentidos.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sentidos.api.dto.OrderDto;
import com.sentidos.api.enitiesWrapper.OrderWrapper;
import com.sentidos.api.entities.Order;
import com.sentidos.api.services.OrderServiceImpl;

@RequestMapping("/api/v1/order/")
@RestController
public class OrderController {
	private Logger log = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderServiceImpl orderService;
	
	@GetMapping("")
	public ResponseEntity<Map<String, Object>> findAll(){
		Map<String, Object> response = new HashMap<String, Object>();		
		List<Order> orders = orderService.findAll();
		List<OrderDto> ordersDto = new ArrayList<OrderDto>();
		
		orders.forEach(item->{
				log.info("ordenes details: "+item.getOrderDetails().size());
				item.getOrderDetails().forEach(d -> log.info(d.getMenu().getName()));
				ordersDto.add(OrderWrapper.entityToDto(item));
		});		
		
		response.put("orders", ordersDto);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Map<String, Object>> save(@RequestBody OrderDto orderDto){
		Map<String, Object> response = new HashMap<String, Object>();		
		Order newOrder = OrderWrapper.dtoToEntity(orderDto);
		newOrder = orderService.save(newOrder);
		if(newOrder != null) {
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
