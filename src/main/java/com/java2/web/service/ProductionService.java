package com.java2.web.service;

import java.util.List;

import com.java2.web.dtos.ProductionDTO;

public interface ProductionService {

	public void addProduction(ProductionDTO production);

	public void removeProduction(int idProduction);

	public void updateProduction(ProductionDTO production);

	public List<ProductionDTO> getProduction();

	public ProductionDTO getProduction(int idProduction);
}
