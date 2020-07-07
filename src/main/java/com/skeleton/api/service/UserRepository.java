package com.skeleton.api.service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skeleton.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
