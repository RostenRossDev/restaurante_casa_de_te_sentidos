package com.sentidos.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentidos.api.dao.IInvoiceDao;
import com.sentidos.api.entities.Invoice;

@Service
public class InvoiceServiceImpl {

	@Autowired
	private IInvoiceDao invoiceDao;
	
	
	public List<Invoice> findAll(){
		return (ArrayList<Invoice>) invoiceDao.findAll();
	}
	
	
}
