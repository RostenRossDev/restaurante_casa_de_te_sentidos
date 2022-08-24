package com.sentidos.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.Reservation;
import com.sentidos.api.entities.RestaurantTable;


@Repository
public interface IReservation extends CrudRepository<Reservation, Long>{
	
}