package com.java2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.OrdersDTO;
import com.java2.web.service.OrdersService;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<OrdersDTO> getOrders() {
		return ordersService.getOrders();
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void addOrders(@RequestBody OrdersDTO orders) {
		ordersService.addOrders(orders);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void removeOrders(@PathVariable int id) {
		ordersService.removeOrders(id);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT)
	public void updateOrders(@RequestBody OrdersDTO orders) {
		ordersService.updateOrders(orders);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public OrdersDTO getOrders(@PathVariable int id) {
		return ordersService.getOrder(id);

	}

}
