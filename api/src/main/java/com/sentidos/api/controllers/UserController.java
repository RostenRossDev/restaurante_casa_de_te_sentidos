package com.sentidos.api.controllers;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sentidos.api.dto.UserDto;
import com.sentidos.api.enitiesWrapper.UserWrapper;
import com.sentidos.api.entities.Customer;
import com.sentidos.api.entities.User;
import com.sentidos.api.services.UserService;

@RestController
@RequestMapping("/api/v1/user/")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	
	@PostMapping("")
	public ResponseEntity<HashMap<String, Object>> createUser(@RequestBody UserDto userDto){	
		
		HashMap<String, Object> response = new HashMap<>();
		User user = userService.findByUsername(userDto.getUsername());
		
		if(user != null) {
			response.put("error", "No puedes usar ese username");
			return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
		}
		
		
		User newUser = UserWrapper.dtoToEntity(userDto);	
		Customer customer = new Customer();		
		customer.setName(userDto.getName());
		customer.setLastname(userDto.getLastname());
		customer.setUser(newUser);
		newUser.setCustomer(customer);	
		
		if( userService.save(newUser) == null) {
			response.put("error", "Error al crear usuario, intente nuevamente mas tarde");
			return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("user", userDto);
		response.put("message", "Usuario creado con eixto");
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
}
