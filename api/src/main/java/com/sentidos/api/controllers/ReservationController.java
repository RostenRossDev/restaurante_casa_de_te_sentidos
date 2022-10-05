package com.sentidos.api.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sentidos.api.dao.IReservation;
import com.sentidos.api.dto.ReservationDesktopDto;
import com.sentidos.api.dto.ReservationDto;
import com.sentidos.api.enitiesWrapper.ReservationWrapper;
import com.sentidos.api.entities.Customer;
import com.sentidos.api.entities.Reservation;
import com.sentidos.api.entities.RestaurantTable;
import com.sentidos.api.entities.User;
import com.sentidos.api.services.ICustomerService;
import com.sentidos.api.services.ReservationService;
import com.sentidos.api.services.TableServiceImpl;
import com.sentidos.api.services.UserService;
import com.sentidos.api.services.CostumerServiceImpl;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

	private Logger log = LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private TableServiceImpl tableService;
	
	@Autowired
	private CostumerServiceImpl customerService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("")
	public ResponseEntity<HashMap<String,Object>> save(@RequestBody ReservationDto reservationDto){
		HashMap<String, Object> response = new HashMap<>();
		Date now = new Date();
		
		log.info(reservationDto.toString());

		Date calendarReservation = reservationDto.getDateReservation();

		Date calendarUnMes = new Date();

		calendarUnMes.setMonth(calendarUnMes.getMonth()+1);	

		Date calendar24hsAntes = new Date(calendarReservation.getYear(), calendarReservation.getMonth(), calendarReservation.getDate());
		
		calendar24hsAntes.setDate(calendar24hsAntes.getDate()-1);	

	    SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MMMM/dd");
	    log.info("1:"+(now.getDate()<=calendarReservation.getDate()));
	    log.info("2:"+(now.getMonth()>=calendarReservation.getMonth()));
	    log.info("3:"+(now.getYear()==calendarReservation.getYear()));
		Boolean afterNow = now.before(calendarReservation);
		Boolean beforeAMonth = calendarUnMes.after(calendarReservation);
		Boolean afterA24Hs = now.compareTo(calendar24hsAntes)>0;		
		log.info(calendarUnMes+": calendarUnMes");
		log.info(calendarReservation+": calendarReservation");
		log.info(afterNow+"");
		log.info(beforeAMonth+"");
		if(afterNow&&beforeAMonth) {
			response.put("payNow", Boolean.FALSE);
			
			if(afterA24Hs) response.put("payNow", Boolean.TRUE);
			
			RestaurantTable table = tableService.findByNumber(reservationDto.getTable());
			
			User user = userService.findByUsername(reservationDto.getUsername()); 
			Customer customer = customerService.findByUser(user);
			Reservation reservation = ReservationWrapper.dtoToEntity(reservationDto);
			
			reservation.setCustomer(customer);
			reservation.setRestaurantTable(table);
			reservation.setDisabled(Boolean.FALSE);
			
			try {
				reservation =reservationService.save(reservation) ;

				if(!reservation.getId().equals(null)){
					response.put("reservation", ReservationWrapper.entityToDto(reservation));
					return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
				}
				response.put("error", "No se pudo realizar la reserva. Intente nuevamente");		
			}catch (DataIntegrityViolationException e) {
				
				response.put("error", "La mesa ya tiene reserva el mismo dia.");
				return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
			}catch (ConstraintViolationException e) {
				
				response.put("error", "La mesa ya tiene reserva el mismo dia.");
				return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
			}			
		}
	
		response.put("message","La reserva no puede superar 1 mes de anticipacion");
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String,Object>> all(){
		HashMap<String, Object> response = new HashMap<>();
		List<Reservation> reservations = reservationService.findAll();
		List<ReservationDto> reservationsDto = new ArrayList<>();
		reservations.forEach(reservation ->{
			ReservationDto newReservationDto = ReservationWrapper.entityToDto(reservation);
			reservationsDto.add(newReservationDto);
		});
		response.put("reservations", reservationsDto);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	} 
	
	@DeleteMapping("")
	public ResponseEntity<HashMap<String, Object>> delete(@RequestBody Long id){
		HashMap<String, Object> response = new HashMap<>();
		if(reservationService.deleteById(id)) {
			log.info("Reserva eliminada");
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}
		log.info("No se encontro");
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@GetMapping("/desktop/all")
	public ResponseEntity<HashMap<String,Object>> allDesktop(){
		HashMap<String, Object> response = new HashMap<>();
		List<Reservation> reservations = reservationService.findAll();
		List<ReservationDesktopDto> reservationsDto = new ArrayList<>();
		reservations.forEach(reservation ->{
			ReservationDesktopDto newReservationDto = ReservationWrapper.entityToDtoDesktop(reservation);
			reservationsDto.add(newReservationDto);
		});
		response.put("reservations", reservationsDto);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	} 
}
