package com.aleksandra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.OrderDao;
import com.aleksandra.dao.OrderItemDao;
import com.aleksandra.model.OrderItem;
import com.aleksandra.model.Orders;
import com.aleksandra.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<OrderItem> getOrderItemsByOrder(Long id) {
		Orders order = orderDao.findById(id);
		return orderItemDao.getOrderItemsByOrder(order);
	}

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemDao.saveOrderItem(orderItem);
	}

	@Override
	public double totalPrice(Long id) {
		return orderItemDao.totalPrice(id);
	}

	@Override
	public void deleteOrderItem(Long id) {
		OrderItem orderItem = orderItemDao.findById(id);
		orderItemDao.deleteOrderItem(orderItem);
	}

}
