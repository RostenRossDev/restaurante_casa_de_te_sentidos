package com.sentidos.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sentidos.api.entities.MenuType;
@Repository
public interface IMenuTypeDao extends CrudRepository<MenuType, Long>{

}
