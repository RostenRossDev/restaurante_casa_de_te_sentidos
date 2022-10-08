package com.sentidos.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.Customer;
import com.sentidos.api.entities.User;

@Repository
public interface ICustomerDao  extends CrudRepository<Customer, Long>{
	
	List<Customer> findByUser(User user);
	
}
