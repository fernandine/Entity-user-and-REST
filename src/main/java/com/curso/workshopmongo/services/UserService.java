package com.curso.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.workshopmongo.domain.User;
import com.curso.workshopmongo.repository.UserRepository;
import com.curso.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {

		return repo.findAll();
	}

	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return user;
	}

}
