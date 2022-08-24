package com.sentidos.api.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.RestaurantTable;

@Repository
public interface ITable extends CrudRepository<RestaurantTable, Long>{

	public RestaurantTable findByNumber(Integer number);
}
