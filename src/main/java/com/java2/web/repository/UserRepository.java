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

	public void addUser(UserEntity user) {
		em.persist(user);
	}

	public void removeUser(int idUser) {
		em.remove(em.find(UserEntity.class, idUser));
	}

	public void updateUser(UserEntity user) {
		UserEntity newUser = em.find(UserEntity.class, user.getId());
		newUser.setLoginName(user.getLoginName());
		newUser.setNickName(user.getNickName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setAddresses(user.getAddresses());
		em.merge(newUser);
	}

	public List<UserEntity> getUsers() {

		return em.createQuery("from UserEntity", UserEntity.class).getResultList();

	}

	public UserEntity getUser(int idUser) {

		return em.find(UserEntity.class, idUser);
	}

}
