package com.java2.web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dtos.OrdersDTO;
import com.java2.web.entity.OrdersEntity;
import com.java2.web.repository.OrdersRepository;
import com.java2.web.service.OrdersService;

@Service
@Transactional
public class OrdersServiceImp implements OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public void addOrders(OrdersDTO orders) {
		OrdersEntity ordersEntity = new OrdersEntity();
		ordersEntity.setCreateDate(orders.getCreateDate());
		ordersEntity.setState(orders.getState());
		ordersEntity.setAddress(orders.getAddress());
		ordersRepository.addOrders(ordersEntity);

	}

	@Override
	public void removeOrders(int idOrders) {
		ordersRepository.removeOrders(idOrders);
	}

	@Override
	public void updateOrders(OrdersDTO orders) {
		OrdersEntity ordersEntity = new OrdersEntity();		
		ordersEntity.setCreateDate(orders.getCreateDate());
		ordersEntity.setState(orders.getState());
		ordersEntity.setAddress(orders.getAddress());
		ordersRepository.updateOrders(ordersEntity);
	}

	@Override
	public List<OrdersDTO> getOrders() {
		List<OrdersEntity> orders = ordersRepository.getOrders();
		List<OrdersDTO> dtos = new ArrayList<>();
		for (OrdersEntity order : orders) {
			OrdersDTO dto = new OrdersDTO();
			dto.setId(order.getId());
			dto.setCreateDate(order.getCreateDate());
			dto.setState(order.getState());
			dto.setAddress(order.getAddress());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public OrdersDTO getOrder(int idOrders) {
		OrdersEntity order = ordersRepository.getOrder(idOrders);
		OrdersDTO dto = new OrdersDTO();
		dto.setId(order.getId());
		dto.setCreateDate(order.getCreateDate());
		dto.setState(order.getState());
		dto.setAddress(order.getAddress());
		return dto;
	}
}
