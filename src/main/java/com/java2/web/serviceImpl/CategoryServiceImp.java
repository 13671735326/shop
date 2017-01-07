package com.java2.web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dtos.CategoryDTO;
import com.java2.web.entity.CategoryEntity;
import com.java2.web.repository.CategoryRepository;
import com.java2.web.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService{

	@Autowired
	private  CategoryRepository categoryRepository;

	@Override
	public void addCategory(CategoryDTO category) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(category.getName());
		categoryEntity.setProductions(category.getProductions());
		categoryRepository.addCategory(categoryEntity);
		
	}

	@Override
	public void removeCategory(int idCategory) {
		categoryRepository.removeCategory(idCategory);
		
	}

	@Override
	public void updateCategory(CategoryDTO category) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(category.getId());
		categoryEntity.setName(category.getName());
		categoryEntity.setProductions(category.getProductions());
		categoryRepository.updateCategory(categoryEntity);
		
	}

	@Override
	public List<CategoryDTO> getCategory() {
		List<CategoryEntity> categoryEntityes = categoryRepository.getCategoryes();
		List<CategoryDTO> dtos = new ArrayList<>();
		for (CategoryEntity category : categoryEntityes) {
			CategoryDTO dto = new CategoryDTO();
			dto.setId(category.getId());
			dto.setName(category.getName());
			dto.setProductions(category.getProductions());			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public CategoryDTO getCategory(int idCategory) {
		CategoryEntity category = categoryRepository.getCategory(idCategory);
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		dto.setProductions(category.getProductions());	
		return dto;
	}


	
}
