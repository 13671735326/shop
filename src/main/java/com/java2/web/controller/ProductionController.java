package com.java2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.ProductionDTO;
import com.java2.web.service.ProductionService;

@RestController
@RequestMapping(path = "/productions")
public class ProductionController {
	@Autowired
	private ProductionService productionService;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void addProduction(@RequestBody ProductionDTO user) {
		productionService.addProduction(user);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void removeProduction(@PathVariable int id) {
		productionService.removeProduction(id);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<ProductionDTO> getProduction() {
		return productionService.getProduction();
	}

	@RequestMapping(path = "", method = RequestMethod.PUT)
	public void updateProduction(@RequestBody ProductionDTO user) {
		productionService.updateProduction(user);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ProductionDTO getProduction(@PathVariable int id) {
		return productionService.getProduction(id);

	}

}
