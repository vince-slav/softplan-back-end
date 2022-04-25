package com.example.api.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.dto.UserDTO;
import com.example.api.entities.User;
import com.example.api.services.UserService;


@RestController
@RequestMapping(value = "/users")

public class UserResource {

	@Autowired
	private UserService service;
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id){
		User u = service.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<User> insert(@Valid @RequestBody UserDTO objDto){
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	
		return ResponseEntity.created(uri).body(obj);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@Valid @PathVariable Integer id, @RequestBody UserDTO objDto){
		User obj = service.fromDTO(objDto);
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
