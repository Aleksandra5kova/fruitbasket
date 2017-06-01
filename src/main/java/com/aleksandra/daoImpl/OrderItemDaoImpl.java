package com.aleksandra.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aleksandra.dao.OrderItemDao;
import com.aleksandra.model.OrderItem;
import com.aleksandra.model.Orders;

@Repository
@Transactional
public class OrderItemDaoImpl implements OrderItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> getOrderItemsByOrder(Orders order) {
		return sessionFactory.getCurrentSession().createCriteria(OrderItem.class).add(Restrictions.eq("order", order))
				.list();
	}

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderItem);
		return orderItem;
	}

}
