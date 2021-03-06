package com.aleksandra.service;

import java.util.List;

import com.aleksandra.model.Orders;

public interface OrderService {
	
	public List<Orders> getOrders();
	
	public Orders saveOrder(Orders order);
	
	public void deleteOrder(Long id);

}
