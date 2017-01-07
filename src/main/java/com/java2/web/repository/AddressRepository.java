package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.entity.AddressEntity;

@Repository
@Transactional
public class AddressRepository {

	@PersistenceContext
	EntityManager em;

	public void addAddress(AddressEntity address) {
		em.persist(address);
	}

	public void removeAddress(int idAddress) {
		em.remove(em.find(AddressEntity.class, idAddress));
	}

	public void updateAddress(AddressEntity address) {
		em.merge(address);
	}

	public List<AddressEntity> getAddresses() {

		return em.createQuery("from AddressEntity", AddressEntity.class).getResultList();

	}

	public AddressEntity getAddress(int idAddress) {
		return em.find(AddressEntity.class, idAddress);
	}
}
