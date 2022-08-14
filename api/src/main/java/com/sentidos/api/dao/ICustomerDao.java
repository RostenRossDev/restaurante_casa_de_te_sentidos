package com.sentidos.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.Customer;

@Repository
public interface ICustomerDao  extends CrudRepository<Customer, Long>{

}
