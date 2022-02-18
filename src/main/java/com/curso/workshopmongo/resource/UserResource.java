package com.curso.workshopmongo.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.workshopmongo.domain.User;
import com.curso.workshopmongo.services.UserService;

@RestController 							//Pra saber que a classe será um recurso REST;
@RequestMapping(value = "/users")			//caminho do endpoint;
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	
	}
}
