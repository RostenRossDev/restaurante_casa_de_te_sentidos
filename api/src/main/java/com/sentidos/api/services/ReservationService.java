package com.sentidos.api.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentidos.api.dao.IReservation;
import com.sentidos.api.entities.Reservation;

@Service
public class ReservationService {

	@Autowired
	private IReservation reservationDao;
	
	
	
	public List<Reservation> findAll(){
		
		return (List<Reservation>) reservationDao.findAll();
	}
	
	public Reservation save(Reservation res) {
		return reservationDao.save(res);
	}
	
	public  List<Reservation> saveAll( List<Reservation> reservations){
		return (List<Reservation>) reservationDao.saveAll(reservations);
	}
	public List<Reservation> uodateAll(List<Reservation> reservationUpdate){
		return (List<Reservation>) reservationDao.saveAll(reservationUpdate);		
	}
	
	public List<Reservation> findByReservationDateAndDisabledAndIsTeaAndHour(Date reservationDate, Boolean disabled, Boolean isTea, Boolean hour ){
		return reservationDao.findByReservationDateAndDisabledAndIsTeaAndHour(reservationDate, disabled, isTea, hour);
	}
}
