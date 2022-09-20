package com.sentidos.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentidos.api.dao.IMenuDao;
import com.sentidos.api.entities.Menu;

@Service
public class MenuService {

	@Autowired
	private IMenuDao menuDao;
	
	public List<Menu> allMenu(){
		List<Menu> menues =(ArrayList<Menu>) menuDao.findAll();
		
		return menues;
	}
	
	public Menu findById(Long id) {
		return menuDao.findById(id).orElse(new Menu());
	}
}

