package com.sentidos.api.services;

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
}
