package com.sentidos.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.OrderDetail;
@Repository
public interface IOrderDetailDao extends CrudRepository<OrderDetail, Long>{

}
