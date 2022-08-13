package com.sentidos.api.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sentidos.api.entities.Post;

@RestController
@RequestMapping("/api/v1/post/")
public class PostController {

	@GetMapping("")
	public ResponseEntity<HashMap<String, Object>> allPost(){
		HashMap<String, Object> response = new HashMap<>();
		response.put("mensaje", "hola");
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<HashMap<String, Object>> savePost( Post post){
		HashMap<String, Object> response = new HashMap<>();

		response.put("post", response);
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
}
