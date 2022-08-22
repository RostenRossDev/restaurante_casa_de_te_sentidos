package com.sentidos.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentidos.api.dao.ICustomerDao;
import com.sentidos.api.entities.Customer;
import com.sentidos.api.entities.User;

@Service
public class CostumerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	public List<Customer> findAll(){
		return (List<Customer>) customerDao.findAll();
	}
	
	public Customer findById(Long id) {
		return customerDao.findById(id).orElse(new Customer());
	}
	
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}
	
	public Customer findByUser(User user) {
		return customerDao.findByUser(user).get(0);
	}
}
