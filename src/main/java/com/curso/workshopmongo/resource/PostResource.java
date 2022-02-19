package com.curso.workshopmongo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.workshopmongo.domain.Post;
import com.curso.workshopmongo.services.PostService;


@RestController 					// Pra saber que a classe será um recurso REST;
@RequestMapping(value = "/posts") 	// caminho do endpoint;
public class PostResource {

	@Autowired
	private PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Post> findById(@PathVariable String id) {
			Post obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
	}
}