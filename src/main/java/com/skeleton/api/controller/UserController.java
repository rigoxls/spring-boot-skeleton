package com.skeleton.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skeleton.api.entity.User;
import com.skeleton.api.service.UserRepository;

@RestController
public class UserController {
		
	@Autowired
	private UserRepository repo;	
	
	@GetMapping(path="/getAllUsers")
	public String getAllUsers() {		
		
		User usuario = new User("rigo", "admin");
		System.out.println(usuario);
	    repo.save(usuario);
		
		return "Prueba uno";		
	}
}
