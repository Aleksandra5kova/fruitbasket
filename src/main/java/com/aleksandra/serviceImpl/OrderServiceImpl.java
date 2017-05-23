package com.aleksandra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.OrderDao;
import com.aleksandra.dao.UserDao;
import com.aleksandra.model.Delivery;
import com.aleksandra.model.Orders;
import com.aleksandra.service.OrderService;
import com.aleksandra.service.SecurityService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SecurityService securityService;
	
	@Override
	public List<Orders> getOrders() {
		String username = securityService.findLoggedInUsername();
		return orderDao.getOrders(username);
	}

	@Override
	public void saveOrder(Orders order) {
		
		String username = securityService.findLoggedInUsername();
		order.setUser(userDao.findByUsername(username));
		
		if(order.getHasDelivey().equals("true")){
			order.setHasDelivey(Delivery.YES.getDelivery());
		} else {
			order.setHasDelivey(Delivery.NO.getDelivery());
		}
		
		orderDao.saveOrder(order);
	}

}
