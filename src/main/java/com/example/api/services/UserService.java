package com.example.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.dto.UserDTO;
import com.example.api.entities.User;
import com.example.api.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public User update(Integer id, User obj) {
		User user = repository.getById(id);
		updateUser(user, obj);
		return repository.save(user);
	}

	private void updateUser(User user, User obj) {
		user.setName(obj.getName());
		user.setSex(obj.getSex());
		user.setEmail(obj.getEmail());
		user.setBirthDate(obj.getBirthDate());
	}
	
	public User fromDTO (UserDTO objDto ) {
		return new User(objDto.getId(), objDto.getName());
	}
}
