package tasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private static final String TIME_ZONE =  "America/Buenos_Aires";   
	
	@Scheduled(cron = "0 0 11", zone = TIME_ZONE)
	public void disableTeaReservationsMorging() {
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");		
		Date today = new Date();		
		today = new Date(formater.format(today));		
		List<Reservation> reservations = reservationService.findByReservationDateAndDisabledAndIsTeaAndHour(today, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
		log.info(reservations.toString());
		
		reservations.forEach(e -> e.setDisabled(!e.getDisabled()));
		log.info(reservations.toString());
		reservationService.saveAll(reservations);
		log.info("Se deshabilitaron las reservas para la casa de Té en el horario de 7hs a 11hs del dia ".concat(formater.format(today)));
	}
	
	@Scheduled(cron = "0 0 19", zone = TIME_ZONE)
	public void disableTeaReservationsAfternoon() {
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");		
		Date today = new Date();		
		today = new Date(formater.format(today));		
		List<Reservation> reservations = reservationService.findByReservationDateAndDisabledAndIsTeaAndHour(today, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);
		log.info(reservations.toString());
		
		reservations.forEach(e -> e.setDisabled(!e.getDisabled()));
		log.info(reservations.toString());
		reservationService.saveAll(reservations);
		log.info("Se deshabilitaron las reservas para la casa de Té en el horario de 15hs a 19hs del dia ".concat(formater.format(today)));
	}
	
	
	@Scheduled(cron = "0 0 15", zone = TIME_ZONE)
	public void disableLunchReservations() {
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");		
		Date today = new Date();		
		today = new Date(formater.format(today));		
		List<Reservation> reservations = reservationService.findByReservationDateAndDisabledAndIsTeaAndHour(today, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE);
		log.info(reservations.toString());
		
		reservations.forEach(e -> e.setDisabled(!e.getDisabled()));
		log.info(reservations.toString());
		reservationService.saveAll(reservations);
		log.info("Se deshabilitaron las reservas el restaurante en el horario de 11hs a 15hs del dia ".concat(formater.format(today)));
	}
	
	@Scheduled(cron = "0 0 00", zone = TIME_ZONE)
	public void disableDinnerhReservations() {
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");		
		Date today = new Date();		
		today = new Date(formater.format(today));		
		List<Reservation> reservations = reservationService.findByReservationDateAndDisabledAndIsTeaAndHour(today, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
		log.info(reservations.toString());
		
		reservations.forEach(e -> e.setDisabled(!e.getDisabled()));
		log.info(reservations.toString());
		reservationService.saveAll(reservations);
		log.info("Se deshabilitaron las reservas para el restaurante en el horario de 19hs a 23:59 hs del dia ".concat(formater.format(today)));
	}
}
