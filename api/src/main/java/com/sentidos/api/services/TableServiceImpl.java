package com.sentidos.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentidos.api.dao.ITable;
import com.sentidos.api.entities.RestaurantTable;

@Service
public class TableServiceImpl {
	
	@Autowired
	private ITable tableDao;
	
	public RestaurantTable findByNumber(Integer number) {
		return tableDao.findByNumber(number);
	}	

}
