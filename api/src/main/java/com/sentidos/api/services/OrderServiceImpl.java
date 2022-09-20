package com.sentidos.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentidos.api.dao.IOrderDao;
import com.sentidos.api.entities.Order;

@Service
public class OrderServiceImpl {

	@Autowired
	private IOrderDao orderDao;
	
	
	public Order save(Order order) {
		return orderDao.save(order);
	}
	
	public Order findById(Long id) {
		return orderDao.findById(id).orElse(new Order());
	}
	
	public List<Order> findAll(){
		return (List<Order>) orderDao.findAll();
	}
		
}
