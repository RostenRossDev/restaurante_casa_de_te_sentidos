package com.sentidos.api.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.Reservation;


@Repository
public interface IReservation extends CrudRepository<Reservation, Long>{
	
	public List<Reservation> findByReservationDateAndDisabledAndIsTeaAndHour(Date reservationDate, Boolean Disable, Boolean isTea, Boolean hour );
		
	
}