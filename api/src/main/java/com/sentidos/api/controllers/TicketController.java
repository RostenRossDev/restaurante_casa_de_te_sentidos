package com.sentidos.api.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.sentidos.api.dto.InvoiceDesktopDto;
import com.sentidos.api.dto.InvoiceListDesktopDto;
import com.sentidos.api.dto.LongDto;
import com.sentidos.api.dto.OrderDesktopDto;
import com.sentidos.api.dto.ReservationDesktopDto;
import com.sentidos.api.enitiesWrapper.InvoiceWrapper;
import com.sentidos.api.enitiesWrapper.ReservationWrapper;
import com.sentidos.api.entities.Customer;
import com.sentidos.api.entities.Invoice;
import com.sentidos.api.entities.Order;
import com.sentidos.api.entities.Reservation;
import com.sentidos.api.entities.User;
import com.sentidos.api.services.CostumerServiceImpl;
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
	
	@Autowired
	private CostumerServiceImpl customerService;
	
	@GetMapping("/desktop/all")
	public ResponseEntity<HashMap<String,Object>> allDesktop(){
		HashMap<String, Object> response = new HashMap<>();
		List<Invoice> tickets = invoiceService.findAll();
		List<InvoiceListDesktopDto> invoicesDto = new ArrayList<>();
		
		for (int i = 0; i < tickets.size(); i++) {
			InvoiceListDesktopDto newInvoiceDto = InvoiceWrapper.entityToDtoDesktop(tickets.get(i));
			invoicesDto.add(newInvoiceDto);
		}				
		response.put("tickets", invoicesDto);		

		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<HashMap<String,Object>> update(@RequestBody InvoiceDesktopDto invoiceDto){
		HashMap<String, Object> response = new HashMap<>();
		Invoice findI = invoiceService.findById(invoiceDto.getId());
		User findU = userService.findByUsername(invoiceDto.getUsername());
		Customer findC = customerService.findByUser(findU);
		if(findI.getId() != null) {
			log.info("fecha de pago: "+invoiceDto.getFechaPago());
			findI.setPaymentDate(invoiceDto.getFechaPago());
			findI.setIsPayment(invoiceDto.getConfirmado());
			findI.setPaymentMethod(invoiceDto.getMetodoPago());
			if(findC.getId() != null) { findI.setCustomer(findC);}
			else {
				response.put("message", "El usuario no existe");
				return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			invoiceService.save(findI);
			
			List<Invoice> tickets = invoiceService.findAll();
			log.info("tickets list: "+tickets.toString());
			List<InvoiceListDesktopDto> invoicesDto = new ArrayList<>();
			for (int i = 0; i < tickets.size(); i++) {
				log.info("ticket: "+tickets.get(i).toString());
				InvoiceListDesktopDto newInvoiceDto = InvoiceWrapper.entityToDtoDesktop(tickets.get(i));
				invoicesDto.add(newInvoiceDto);
			}				
			response.put("tickets", invoicesDto);	
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}
		response.put("message", "ah ocurrido un error.");
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("")
	public ResponseEntity<HashMap<String,Object>> delete(@RequestBody LongDto invoiceId){
		HashMap<String, Object> response = new HashMap<>();
		if(invoiceService.deleteById(invoiceId.getId())) {
			response.put("message", "Ticket eliminado");
			List<Invoice> tickets = invoiceService.findAll();
			log.info("tickets list: "+tickets.toString());
			List<InvoiceListDesktopDto> invoicesDto = new ArrayList<>();
			for (int i = 0; i < tickets.size(); i++) {
				log.info("ticket: "+tickets.get(i).toString());
				InvoiceListDesktopDto newInvoiceDto = InvoiceWrapper.entityToDtoDesktop(tickets.get(i));
				invoicesDto.add(newInvoiceDto);
			}				
			response.put("tickets", invoicesDto);	
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}
		response.put("message", "Error al eliminar el ticket");
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
}
