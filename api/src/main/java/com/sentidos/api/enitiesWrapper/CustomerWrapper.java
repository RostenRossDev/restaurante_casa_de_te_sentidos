package com.sentidos.api.enitiesWrapper;

import com.sentidos.api.dto.CustomerDto;
import com.sentidos.api.entities.Customer;

public class CustomerWrapper {
	
	public static Customer dtoToEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setLastname(customerDto.getLastname());
		return customer;
	}
	public static CustomerDto entityToDto(Customer customer) {
		CustomerDto custoemrDto = new CustomerDto();
		custoemrDto.setName(customer.getName());
		custoemrDto.setLastname(customer.getLastname());
		custoemrDto.setUsername(customer.getUser().getUsername());
		return custoemrDto;
	}
}
