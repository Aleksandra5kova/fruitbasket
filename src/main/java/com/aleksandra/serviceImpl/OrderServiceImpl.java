package com.aleksandra.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.OrderDao;
import com.aleksandra.dao.OrderItemDao;
import com.aleksandra.dao.UserDao;
import com.aleksandra.model.Orders;
import com.aleksandra.service.OrderService;
import com.aleksandra.service.SecurityService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderItemDao orderItemDao;

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
	public Orders saveOrder(Orders order) {
		String username = securityService.findLoggedInUsername();
		order.setUser(userDao.findByUsername(username));
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
		try {
			if (order.getDeliveryDate() != null) {
				order.setDeliveryDate(dt.parse(order.getDeliveryDate().toString()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return orderDao.saveOrder(order);
	}

	@Override
	@Transactional
	public void deleteOrder(Long id) {
		Orders order = orderDao.findById(id);
		orderDao.deleteOrder(order);
		orderItemDao.deleteOrderItemsByOrder(id);
	}

}
