package com.aleksandra.dao;

import java.util.List;

import com.aleksandra.model.OrderItem;
import com.aleksandra.model.Orders;

public interface OrderItemDao {

	public List<OrderItem> getOrderItemsByOrder(Orders order);
	
	public OrderItem saveOrderItem(OrderItem orderItem);
	
}
