package com.sentidos.api.enitiesWrapper;


import java.util.Date;

import com.sentidos.api.dto.ReservationDesktopDto;
import com.sentidos.api.dto.ReservationDto;
import com.sentidos.api.entities.Reservation;

public class ReservationWrapper {
	
	public static Reservation dtoToEntity(ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
		reservation.setReservationDate(reservationDto.getDateReservation());
		reservation.setIsTea(reservationDto.getIsTea());
		reservation.setHour(reservationDto.getHour());
		reservation.setConfirmed(reservationDto.getConfirmed());
		reservation.setLocation(reservationDto.getLocation());
		reservation.setDisabled(reservationDto.getDisabled());
		return reservation;
	}
	public static ReservationDto entityToDto(Reservation reservation) {
		ReservationDto reservationDto = new ReservationDto();
		reservationDto.setDateReservation(reservation.getReservationDate());
		reservationDto.setTable(reservation.getRestaurantTable().getNumber());
		reservationDto.setUsername(reservation.getCustomer().getUser().getUsername());
		reservationDto.setConfirmed(reservation.getConfirmed());
		reservationDto.setIsTea(reservation.getIsTea());
		reservationDto.setHour(reservation.getHour());
		reservationDto.setLocation(reservation.getLocation()); 
		reservationDto.setDisabled(reservation.getDisabled());

		return reservationDto;
	}
	
	public static ReservationDesktopDto entityToDtoDesktop(Reservation reservation) {
		ReservationDesktopDto reservationDto = new ReservationDesktopDto();
		reservationDto.setId(reservation.getId());
		reservationDto.setDateReservation(reservation.getReservationDate());

		if(reservation.getReservationDate() != null) {
			
			Date f = reservation.getReservationDate();
			reservationDto.setDateReservationString(f.getYear()+"-"+f.getMonth()+"-"+f.getDate());
			reservationDto.setDateReservation(reservation.getReservationDate());

		}else {
			reservationDto.setDateReservation(reservation.getReservationDate());
		}
		reservationDto.setTable(reservation.getRestaurantTable().getNumber());
		reservationDto.setUsername(reservation.getCustomer().getUser().getUsername());
		reservationDto.setConfirmed(reservation.getConfirmed());
		reservationDto.setIsTea(reservation.getIsTea());
		reservationDto.setHour(reservation.getHour());
		reservationDto.setLocation(reservation.getLocation()); 
		reservationDto.setDisabled(reservation.getDisabled());

		return reservationDto;
	}
}
