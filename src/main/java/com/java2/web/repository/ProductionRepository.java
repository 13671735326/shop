package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.entity.ProductionEntory;

@Repository
public class ProductionRepository {

	@PersistenceContext
	EntityManager em;

	public void addProduction(ProductionEntory production) {
		em.persist(production);
	}

	public void removeProduction(int idProduction) {
		em.remove(em.find(ProductionEntory.class, idProduction));
	}

	public void updateProduction(ProductionEntory production) {
		ProductionEntory productionEntory = em.find(ProductionEntory.class, production.getId());
		productionEntory.setName(production.getName());;
		productionEntory.setDescription(production.getDescription());
		productionEntory.setOriginalPrice(production.getOriginalPrice());
		productionEntory.setPrice(production.getPrice());
		productionEntory.setCategorys(production.getCategorys());
		em.merge(productionEntory);
	}

	public List<ProductionEntory> getProduction() {

		return em.createQuery("from ProductionEntory", ProductionEntory.class).getResultList();

	}

	public ProductionEntory getProduction(int idProduction) {
		return em.find(ProductionEntory.class, idProduction);
	}
}
