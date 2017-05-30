package com.aleksandra.dao;

import java.util.List;

import com.aleksandra.model.Orders;

public interface OrderDao {

	public List<Orders> getOrders(String username);
	
	public Orders saveOrder(Orders order);
	
	public Orders findById(Long id);

	public void deleteOrder(Orders order);
	
}
