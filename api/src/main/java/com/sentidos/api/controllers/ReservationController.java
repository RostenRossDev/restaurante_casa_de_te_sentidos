package com.sentidos.api.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sentidos.api.dao.IReservation;
import com.sentidos.api.dto.ReservationDto;
import com.sentidos.api.enitiesWrapper.ReservationWrapper;
import com.sentidos.api.entities.Customer;
import com.sentidos.api.entities.Reservation;
import com.sentidos.api.entities.RestaurantTable;
import com.sentidos.api.entities.User;
import com.sentidos.api.services.ICustomerService;
import com.sentidos.api.services.TableServiceImpl;
import com.sentidos.api.services.UserService;
import com.sentidos.api.services.CostumerServiceImpl;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

	@Autowired
	private IReservation reservationDao;
	
	@Autowired
	private TableServiceImpl tableService;
	
	@Autowired
	private CostumerServiceImpl customerService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("")
	public ResponseEntity<HashMap<String,Object>> save(@RequestBody ReservationDto reservationDto){
		HashMap<String, Object> response = new HashMap<>();
		RestaurantTable table = tableService.findByNumber(reservationDto.getTable());
		
		User user = userService.findByUsername(reservationDto.getUsername()); 
		Customer customer = customerService.findByUser(user);
		Reservation reservation = ReservationWrapper.dtoToEntity(reservationDto);
		
		reservation.setCustomer(customer);
		reservation.setRestaurantTable(table);
		
		reservation =reservationDao.save(reservation) ;
		
		if(!reservation.getId().equals(null)){
			response.put("reservation", reservation);
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}
		response.put("error", "No se pudo realizar la reserva. Intente nuevamente");		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String,Object>> all(){
		HashMap<String, Object> response = new HashMap<>();
		
		
		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	} 
}
