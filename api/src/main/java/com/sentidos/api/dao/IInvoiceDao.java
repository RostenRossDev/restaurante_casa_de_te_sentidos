package com.sentidos.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.Invoice;

@Repository
public interface IInvoiceDao extends CrudRepository<Invoice, Long> {

	
}
