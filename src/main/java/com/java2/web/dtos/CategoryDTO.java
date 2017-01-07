package com.java2.web.dtos;

import java.util.List;

import com.java2.web.entity.ProductionEntory;

public class CategoryDTO {
	private int id;
	private String name;

	List<ProductionEntory> productions;

	public List<ProductionEntory> getProductions() {
		return productions;
	}

	public void setProductions(List<ProductionEntory> productions) {
		this.productions = productions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
