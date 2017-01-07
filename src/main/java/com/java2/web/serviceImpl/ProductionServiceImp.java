package com.java2.web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dtos.ProductionDTO;
import com.java2.web.entity.ProductionEntory;
import com.java2.web.repository.ProductionRepository;
import com.java2.web.service.ProductionService;

@Service
@Transactional
public class ProductionServiceImp implements ProductionService {
	@Autowired
	ProductionRepository productionPositity;

	@Override
	public void addProduction(ProductionDTO production) {
		ProductionEntory productionEntity = new ProductionEntory();
		productionEntity.setId(production.getId());
		productionEntity.setName(production.getName());
		;
		productionEntity.setDescription(production.getDescription());
		productionEntity.setOriginalPrice(production.getOriginalPrice());
		productionEntity.setPrice(production.getPrice());
		productionEntity.setCategorys(production.getCategorys());
		productionPositity.addProduction(productionEntity);

	}

	@Override
	public void removeProduction(int idProduction) {
		productionPositity.removeProduction(idProduction);

	}

	@Override
	public void updateProduction(ProductionDTO production) {
		ProductionEntory productionEntity = new ProductionEntory();
		productionEntity.setName(production.getName());
		;
		productionEntity.setDescription(production.getDescription());
		productionEntity.setOriginalPrice(production.getOriginalPrice());
		productionEntity.setPrice(production.getPrice());
		productionEntity.setCategorys(production.getCategorys());
		productionPositity.updateProduction(productionEntity);

	}

	@Override
	public List<ProductionDTO> getProduction() {
		List<ProductionEntory> productiones = productionPositity.getProduction();
		List<ProductionDTO> dtos = new ArrayList<>();
		for (ProductionEntory production : productiones) {
			ProductionDTO dto = new ProductionDTO();
			dto.setId(production.getId());
			dto.setName(production.getName());
			;
			dto.setDescription(production.getDescription());
			dto.setOriginalPrice(production.getOriginalPrice());
			dto.setPrice(production.getPrice());
			dto.setCategorys(production.getCategorys());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public ProductionDTO getProduction(int idProduction) {
		ProductionEntory production = productionPositity.getProduction(idProduction);
		ProductionDTO dto = new ProductionDTO();
		dto.setId(production.getId());
		dto.setName(production.getName());
		;
		dto.setDescription(production.getDescription());
		dto.setOriginalPrice(production.getOriginalPrice());
		dto.setPrice(production.getPrice());
		dto.setCategorys(production.getCategorys());
		return dto;
	}

}
