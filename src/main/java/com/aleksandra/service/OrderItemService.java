package com.aleksandra.service;

import java.util.List;

import com.aleksandra.model.OrderItem;

public interface OrderItemService {
	
	public List<OrderItem> getOrderItemsByOrder(Long id);
	
	public OrderItem saveOrderItem(OrderItem orderItem);

	public double totalPrice(Long id);
	
	public void deleteOrderItem(Long id);

}
