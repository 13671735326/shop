package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
//	public void addUser(UserEntity user) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatePersistenceUnit");
//		EntityManager em = factory.createEntityManager();
//
//		em.getTransaction().begin();
//		em.persist(user);
//		em.getTransaction().commit();
//
//		em.close();
//		factory.close();
//
//	}

	public void removeUser(UserEntity user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatePersistenceUnit");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		UserEntity entity = em.find(UserEntity.class, user.getId());
		em.remove(entity);

		em.getTransaction().commit();

		em.close();
		factory.close();

	}

	public void updateStudent(UserEntity user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatePersistenceUnit");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		UserEntity entity = em.find(UserEntity.class, user.getId());
		entity.setName(user.getName());
		entity.setAge(user.getAge());
		entity.setSex(user.getSex());
		entity.setClasses(user.getClasses());

		em.merge(entity);
		em.getTransaction().commit();

		em.close();
		factory.close();

	}

	public UserEntity findUser(int userId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatePersistenceUnit");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		UserEntity entity = em.find(UserEntity.class, userId);

		em.close();
		factory.close();
		return entity;
		
	}

	public List<UserEntity> getListUser() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatePersistenceUnit");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<UserEntity> allUser = em.createNativeQuery("from ComputerEntity", UserEntity.class)
				.getResultList();

		em.close();
		factory.close();
		return allUser;
	}

}
