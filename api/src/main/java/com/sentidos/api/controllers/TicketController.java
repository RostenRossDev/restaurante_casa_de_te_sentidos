package com.sentidos.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.sentidos.api.dto.InvoiceDesktopDto;
import com.sentidos.api.dto.OrderDesktopDto;
import com.sentidos.api.dto.ReservationDesktopDto;
import com.sentidos.api.enitiesWrapper.InvoiceWrapper;
import com.sentidos.api.enitiesWrapper.ReservationWrapper;
import com.sentidos.api.entities.Invoice;
import com.sentidos.api.entities.Order;
import com.sentidos.api.entities.Reservation;
import com.sentidos.api.services.InvoiceServiceImpl;
import com.sentidos.api.services.OrderServiceImpl;
import com.sentidos.api.services.UserService;

@RequestMapping("/api/v1/invoice")
@RestController
public class TicketController {
	private Logger log = LoggerFactory.getLogger(TicketController.class);

	@Autowired
	private InvoiceServiceImpl invoiceService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/desktop/all")
	public ResponseEntity<HashMap<String,Object>> allDesktop(){
		HashMap<String, Object> response = new HashMap<>();
		List<Invoice> tickets = invoiceService.findAll();
		List<InvoiceDesktopDto> invoicesDto = new ArrayList<>();
		
		for (int i = 0; i < tickets.size(); i++) {
			InvoiceDesktopDto newInvoiceDto = InvoiceWrapper.entityToDtoDesktop(tickets.get(i));
			invoicesDto.add(newInvoiceDto);
		}				
		response.put("tickets", invoicesDto);		

		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
}
