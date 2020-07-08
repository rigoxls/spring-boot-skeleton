package com.skeleton.api.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skeleton.api.repository.UserEntity;

@Repository
@Transactional
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public long updateUser(UserEntity user) {
		entityManager.persist(user);
		return user.getId();
	}
}
