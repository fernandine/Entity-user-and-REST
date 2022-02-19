package com.curso.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.workshopmongo.domain.User;
import com.curso.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(User id) {
		repo.delete(id);
	}
	
	public User update(User obj) {
		User newObj = repo.findOne(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
	
	
	
	public User fromDTO(UserDTO objDTO ) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

}
