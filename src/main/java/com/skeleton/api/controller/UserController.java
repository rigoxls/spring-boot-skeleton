package com.skeleton.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping(path="/getAllUsers")
	public String getAllUsers() {
		return "Prueba uno";		
	}
}
