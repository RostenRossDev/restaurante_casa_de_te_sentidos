package com.sentidos.api.enitiesWrapper;


import com.sentidos.api.dto.ReservationDto;
import com.sentidos.api.entities.Reservation;

public class ReservationWrapper {
	
	public static Reservation dtoToEntity(ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
		reservation.setReservationDate(reservationDto.getDateReservation());
		//reservation.setRestaurantTable(reservationDto.getTable());
		//reservation.setCustomer(reservationDto.getTable());
		return reservation;
	}
	public static ReservationDto entityToDto(Reservation reservation) {
		ReservationDto reservationDto = new ReservationDto();
		reservationDto.setDateReservation(reservation.getReservationDate());
		reservationDto.setTable(reservation.getRestaurantTable().getNumber());
		reservationDto.setUsername(reservation.getCustomer().getUser().getUsername());
		return reservationDto;
	}
}