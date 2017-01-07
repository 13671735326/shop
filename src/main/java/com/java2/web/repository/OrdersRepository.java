package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.entity.OrdersEntity;
import com.java2.web.entity.UserEntity;

@Repository
public class OrdersRepository {
	@PersistenceContext
	EntityManager em;

	public void addOrders(OrdersEntity user) {
		em.persist(user);
	}

	public void removeOrders(int idUser) {
		em.remove(em.find(OrdersEntity.class, idUser));
	}

	public void updateOrders(OrdersEntity orders) {
		OrdersEntity newOrders = em.find(OrdersEntity.class, orders.getId());
		newOrders.setCreateDate(orders.getCreateDate());
		newOrders.setState(orders.getState());
		newOrders.setAddress(orders.getAddress());
		em.merge(newOrders);
	}

	public List<OrdersEntity> getOrders() {

		return em.createQuery("from OrdersEntity", OrdersEntity.class).getResultList();

	}

	public OrdersEntity getOrder(int idOrders) {

		return em.find(OrdersEntity.class, idOrders);
	}

}
