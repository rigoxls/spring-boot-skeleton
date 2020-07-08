package com.skeleton.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeleton.api.dto.UserDTO;
import com.skeleton.api.repository.UserEntity;
import com.skeleton.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDAOService userDAOService;

	protected UserService() {	
		
	}
	
	public UserEntity createUser(UserDTO newUser) {
		UserEntity user = new UserEntity(newUser);
		System.out.println(user);
		userRepository.save(user);
		return user;
	}
	
	public UserEntity updateUser(UserDTO userToUpdate) {
		Long userId = userToUpdate.getId();		
		
		//TODO y si no encuentra nada ??, validar
		UserEntity user = userRepository.getOne(userId);
		user.setAll(userToUpdate);
		userRepository.save(user);			
		
		return user;
	}
	
	
	public Optional<UserEntity> getUserById(long userId) {
		Optional<UserEntity> user = userRepository.findById(userId);
		return user;
	}
	
	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = userRepository.findAll();
		return users;
	}
	
	public Void deleteUser(long userId) {
		userRepository.deleteById(userId);
		return null;
	}

}
