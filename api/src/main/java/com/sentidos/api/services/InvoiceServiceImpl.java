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
	
	public Invoice findById(Long id) {
		return invoiceDao.findById(id).orElse(new Invoice());
	}
	
	public Invoice save (Invoice invoice) {
		return invoiceDao.save(invoice);
	}
	
	public Boolean deleteById(Long id) {
		try {
			invoiceDao.deleteById(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			// TODO: handle exception
			return Boolean.FALSE;
		}
	}
}
