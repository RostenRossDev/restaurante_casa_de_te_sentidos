package com.sentidos.api.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sentidos.api.entities.Reservation;
import com.sentidos.api.services.ReservationService;

@Component
@EnableScheduling
public class ScheduledReserveDisabler {
	private Logger log = LoggerFactory.getLogger(ScheduledReserveDisabler.class);
	
	@Autowired
	private ReservationService reservationService;
	
	//private static final String TIME_ZONE =  "America/Buenos_Aires";   
	
	@Scheduled(cron = "0 0 10 * * ?")
	public void disableTeaReservationsMorging() {
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");		
		Date today = new Date();		
		today = new Date(today.getYear(), today.getMonth(), (today.getDate()));		
		List<Reservation> reservations = reservationService.findByReservationDateAndDisabledAndIsTeaAndHour(today, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
		log.info("ReservaS: "+reservations.toString());
		
		reservations.forEach(e -> e.setDisabled(!e.getDisabled()));
		log.info("res updated: "+reservations.toString());
		reservationService.saveAll(reservations);
		log.info("Se deshabilitaron las reservas para la casa de Té en el horario de 7hs a 11hs del dia ".concat(formater.format(today)));
	}
	
	@Scheduled(cron = "0 0 19 * * ?")
	public void disableTeaReservationsAfternoon() {
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");		
		Date today = new Date();		
		today = new Date(today.getYear(), today.getMonth(), (today.getDate()));		
		List<Reservation> reservations = reservationService.findByReservationDateAndDisabledAndIsTeaAndHour(today, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);
		log.info(reservations.toString());
		
		reservations.forEach(e -> e.setDisabled(!e.getDisabled()));
		log.info(reservations.toString());
		reservationService.saveAll(reservations);
		log.info("Se deshabilitaron las reservas para la casa de Té en el horario de 15hs a 19hs del dia ".concat(formater.format(today)));
	}
	
	
	@Scheduled(cron = "0 0 15 * * ?")
	public void disableLunchReservations() {
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");		
		Date today = new Date();		
		today = new Date(today.getYear(), today.getMonth(), (today.getDate()));		
		List<Reservation> reservations = reservationService.findByReservationDateAndDisabledAndIsTeaAndHour(today, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE);
		log.info(reservations.toString());
		
		reservations.forEach(e -> e.setDisabled(!e.getDisabled()));
		log.info(reservations.toString());
		reservationService.saveAll(reservations);
		log.info("Se deshabilitaron las reservas el restaurante en el horario de 11hs a 15hs del dia ".concat(formater.format(today)));
	}
	
	@Scheduled(cron = "0 0 00 * * ?")
	public void disableDinnerhReservations() {
		log.info("iniciando");

		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");		
		Date today = new Date();		
		today = new Date(today.getYear(), today.getMonth(), (today.getDate()-1));	
		log.info("fecha:"+today);
		List<Reservation> reservations = reservationService.findByReservationDateAndDisabledAndIsTeaAndHour(today, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
		log.info(reservations.toString());
		
		reservations.forEach(e -> e.setDisabled(!e.getDisabled()));
		log.info(reservations.toString());
		reservationService.saveAll(reservations);
		log.info("Se deshabilitaron las reservas para el restaurante en el horario de 19hs a 23:59 hs del dia ".concat(formater.format(today)));
	}
	
	/*
	 * @Async
	@Scheduled(fixedDelay = 1000)
	public void everySecond() {
		log.info("cada segundo");
	}
	*/
}
