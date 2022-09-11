package com.sentidos.api.dao;


import com.sentidos.api.entities.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuDao extends CrudRepository<Menu, Long> {

    List<Menu> findAll(Menu menu);


}
