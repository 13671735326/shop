package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.entity.UserEntity;

@Repository
public class UserRepository {
	@PersistenceContext
	EntityManager em;
	
	public List<UserEntity> getUsers(){
		
		return em.createQuery("from UserEntity",UserEntity.class).getResultList();
		
	}
	
	public void addUser(UserEntity user){
		em.persist(user);
	}
	

}
