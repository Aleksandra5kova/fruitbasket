package com.aleksandra.dao;

import java.util.List;

import com.aleksandra.model.Orders;

public interface OrderDao {

	public List<Orders> getOrders(String username);
	
	public void saveOrder(Orders order);

}
