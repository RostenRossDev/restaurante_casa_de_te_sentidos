package com.sentidos.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.Order;
@Repository
public interface IOrderDao extends CrudRepository<Order, Long>{

}
