package com.java2.web.service;

import java.util.List;

import com.java2.web.dtos.CategoryDTO;

public interface CategoryService {

	public void addCategory(CategoryDTO category);

	public void removeCategory(int idCategory);

	public void updateCategory(CategoryDTO category);

	public List<CategoryDTO> getCategory();

	public CategoryDTO getCategory(int idCategory);
}
