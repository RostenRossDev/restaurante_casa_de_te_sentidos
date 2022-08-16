package com.sentidos.api.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sentidos.api.dto.CustomerDto;
import com.sentidos.api.dto.PostDto;
import com.sentidos.api.dto.UserDto;
import com.sentidos.api.enitiesWrapper.CustomerWrapper;
import com.sentidos.api.enitiesWrapper.PostWraper;
import com.sentidos.api.enitiesWrapper.UserWrapper;
import com.sentidos.api.entities.Post;
import com.sentidos.api.entities.User;
import com.sentidos.api.services.CostumerServiceImpl;
import com.sentidos.api.services.PostServiceImpl;
import com.sentidos.api.services.UserService;

//@CrossOrigin({"https://cyan-doors-clap-190-183-177-173.loca.lt"})
@RestController
@RequestMapping("/api/v1/post/")
public class PostController {


	@Autowired
	private UserService userService;
	
	@Autowired
	private CostumerServiceImpl costumerService;
	
	@Autowired
	private PostServiceImpl postService;
	
	@GetMapping(value= "",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<HashMap<String, Object>> allPost(){
		HashMap<String, Object> response = new HashMap<>();
		List<PostDto> postDtos = postService.findAll().stream().map(post -> PostWraper.entityToDto(post)).toList();
		response.put("posts", postDtos);
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
	
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("")
	public ResponseEntity<HashMap<String, Object>> savePost( Post post, User user){
		HashMap<String, Object> response = new HashMap<>();

		response.put("post", response);
		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
	
	@Secured({"ROLE_USER"})
	@GetMapping("tables")
	public ResponseEntity<HashMap<String, Object>> allTables(){
		HashMap<String, Object> response = new HashMap<>();
		List<PostDto> postDtos = postService.findAll().stream().map(post -> PostWraper.entityToDto(post)).toList();
		
		List<UserDto> userDtos = userService.findAll().stream().map(post -> UserWrapper.entityToDto(post)).toList();
		
		List<CustomerDto> custoemrDtos = costumerService.findAll().stream().map(post -> CustomerWrapper.entityToDto(post)).toList();

		response.put("posts", postDtos);
		response.put("userDtos", userDtos);
		response.put("custoemrDtos", custoemrDtos);

		return  new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}
}
