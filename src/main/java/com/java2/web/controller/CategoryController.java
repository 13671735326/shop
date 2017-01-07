package com.java2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.CategoryDTO;
import com.java2.web.service.CategoryService;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<CategoryDTO> getCategory() {
		return categoryService.getCategory();
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void addUser(@RequestBody CategoryDTO category) {
		categoryService.addCategory(category);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void removeUser(@PathVariable int id) {
		categoryService.removeCategory(id);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT)
	public void updateUser(@RequestBody CategoryDTO category) {
		categoryService.updateCategory(category);
	}

	 @RequestMapping(path = "/{id}", method = RequestMethod.GET)
	 public CategoryDTO getUse(@PathVariable int id) {
	 return categoryService.getCategory(id);
	
	 }
}
