package com.skeleton.api.controller;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.skeleton.api.dto.UserDTO;
import com.skeleton.api.repository.UserEntity;
import com.skeleton.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/get/{userId}")
	public Optional<UserEntity> getUserById(@PathVariable long userId) {
		Optional<UserEntity> user = userService.getUserById(userId);
		return user;
	}

	@GetMapping("/user/list")
	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = userService.getAllUsers();
		return users;
	}

	@PostMapping("/user/create")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO newUser) throws IOException {
		UserEntity user = userService.createUser(newUser);
		if (user == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/user/update")
	public HashMap<String, Object> updateUser(@Valid @RequestBody UserDTO userToUpdate) throws Exception {
		UserEntity user = userService.updateUser(userToUpdate);
		return user.getPublicData();
	}

	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}
}
