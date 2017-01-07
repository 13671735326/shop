package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.entity.CategoryEntity;
import com.java2.web.entity.UserEntity;

@Repository
@Transactional
public class CategoryRepository {


	@PersistenceContext
	EntityManager em;

	public void addCategory(CategoryEntity category) {
		em.persist(category);
	}

	public void removeCategory(int idCategory) {
		em.remove(em.find(CategoryEntity.class, idCategory));
	}

	public void updateCategory(CategoryEntity category) {
		CategoryEntity category2 = em.find(CategoryEntity.class, category.getId());
		category2.setName(category.getName());
		category2.setProductions(category.getProductions());
		em.merge(category2);
	}

	public List<CategoryEntity> getCategoryes() {

		return em.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();

	}

	public CategoryEntity getCategory(int idCategory) {
		return em.find(CategoryEntity.class, idCategory);
	}
}
