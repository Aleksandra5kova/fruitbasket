package com.aleksandra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.OrderDao;
import com.aleksandra.model.Orders;
import com.aleksandra.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Orders> getOrders() {
		return orderDao.getOrders();
	}

}
