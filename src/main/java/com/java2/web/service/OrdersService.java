package com.java2.web.service;

import java.util.List;

import com.java2.web.dtos.OrdersDTO;

public interface OrdersService {

	public void addOrders(OrdersDTO orders);

	public void removeOrders(int idOrdersr);

	public void updateOrders(OrdersDTO orders);

	public List<OrdersDTO> getOrders();

	public OrdersDTO getOrder(int idOrders);

}
